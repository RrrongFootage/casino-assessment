package za.co.casino.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.casino.common.enums.TransactionType;
import za.co.casino.mapper.CasinoMapper;
import za.co.casino.model.dto.BalanceUpdateRequestDTO;
import za.co.casino.model.dto.BalanceUpdateResponseDTO;
import za.co.casino.model.dto.TransactionsRequestDTO;
import za.co.casino.persistence.entity.TransactionInformation;
import za.co.casino.persistence.repository.PlayerInfoRepository;
import za.co.casino.persistence.repository.TransactionInfoRepository;
import za.co.casino.service.CasinoService;
import za.co.casino.util.CasinoUtil;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CasinoServiceImpl implements CasinoService {

    private final PlayerInfoRepository playerInfoRepository;
    private final TransactionInfoRepository transactionInfoRepository;
    private final CasinoMapper mapper;

    @Override
    public ResponseEntity getPlayerInfo(int playerId) {
        var playerInfo = playerInfoRepository.findById(playerId);

        if(playerInfo.isPresent()) {
            return ResponseEntity.ok(mapper.mapPlayerInformationEntityToBalanceDTO(playerInfo.get()));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity updatePlayerBalance(int playerId, BalanceUpdateRequestDTO balanceUpdateRequestDTO) {
        var playerInfo = playerInfoRepository.findById(playerId);

        if(!playerInfo.isPresent()) {
            return ResponseEntity.badRequest().body("player does not exist");
        }

        var playerInformation = playerInfo.get();

        if(playerInformation.getBalance().compareTo(new BigDecimal("0.00")) < 0){
            return ResponseEntity.status(418).build();
        }

        if (TransactionType.WIN.equals(balanceUpdateRequestDTO.getTransactionType())) {
            CasinoUtil.addBalanceAmount(playerInformation, balanceUpdateRequestDTO.getAmount());
        } else if(TransactionType.WAGER.equals(balanceUpdateRequestDTO.getTransactionType())){
            CasinoUtil.subtractBalanceAmount(playerInformation, balanceUpdateRequestDTO.getAmount());
            if(playerInformation.getBalance().compareTo(balanceUpdateRequestDTO.getAmount()) < 0){
                return ResponseEntity.badRequest().build();
            }
        }
        TransactionInformation transactionInformation = mapper.mapBalanceUpdateRequestDTOToTransactionInformationEntity(balanceUpdateRequestDTO);
        transactionInformation.setPlayerInformation(playerInformation);

        var transactionResult = transactionInfoRepository.save(transactionInformation);
        return ResponseEntity.ok(
                BalanceUpdateResponseDTO
                        .builder()
                        .balance(playerInformation.getBalance())
                        .transactionId(transactionResult.getId())
                        .build());
    }

    @Override
    public ResponseEntity getPlayerTransactions(TransactionsRequestDTO transactionsRequestDTO) {
        var playerInfo = playerInfoRepository.findPlayerInformationByUsername(transactionsRequestDTO.getUsername());
        if(Objects.isNull(playerInfo)){
            return ResponseEntity.badRequest().build();
        }
        var transactions =
                transactionInfoRepository.findTop10TransactionInformationByPlayerInformation_UsernameOrderByIdDesc(playerInfo.getUsername());
        return ResponseEntity.ok(mapper.mapTransactionInfoEntityListToTransactionDTOList(transactions));
    }
}
