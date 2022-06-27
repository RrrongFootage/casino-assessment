package za.co.casino.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import za.co.casino.model.dto.BalanceDTO;
import za.co.casino.model.dto.BalanceUpdateRequestDTO;
import za.co.casino.model.dto.BalanceUpdateResponseDTO;
import za.co.casino.model.dto.TransactionDTO;
import za.co.casino.persistence.entity.PlayerInformation;
import za.co.casino.persistence.entity.TransactionInformation;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface CasinoMapper {

    @Mapping(target = "transactionId", source = "id")
    TransactionDTO mapTransactionInfoEntityToTransactionDTO(TransactionInformation transactionInformation);

    List<TransactionDTO> mapTransactionInfoEntityListToTransactionDTOList(List<TransactionInformation> transactionInformationEntities);

    @Mapping(target = "playerId", source = "id")
    @Mapping(target = "balance", source = "balance")
    BalanceDTO mapPlayerInformationEntityToBalanceDTO(PlayerInformation playerInformation);


    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "transactionType", source = "transactionType")
    TransactionInformation mapBalanceUpdateRequestDTOToTransactionInformationEntity(BalanceUpdateRequestDTO balanceUpdateRequestDTO);

    @Mapping(target = "transactionId", source = "transactionInformationEntities", qualifiedByName = "getTransactionIdFromPlayerInfoEntity")
    @Mapping(target = "balance", source = "balance")
    BalanceUpdateResponseDTO mapPlayerInformationEntityToBalanceUpdateResponseDTO(PlayerInformation playerInformation);

    @Named("getTransactionIdFromPlayerInfoEntity")
    default Integer getTransactionIdFromPlayerInfoEntity (List<TransactionInformation> transactionInformationEntities) {
       return transactionInformationEntities.get(0).getId();
    }
}



