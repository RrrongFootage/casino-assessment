package za.co.casino.service;

import org.springframework.http.ResponseEntity;
import za.co.casino.model.dto.BalanceUpdateRequestDTO;
import za.co.casino.model.dto.TransactionsRequestDTO;

public interface CasinoService {

    ResponseEntity getPlayerInfo(int playerId);

    ResponseEntity updatePlayerBalance(int playerId, BalanceUpdateRequestDTO balanceUpdateRequestDTO);

    ResponseEntity getPlayerTransactions(TransactionsRequestDTO TransactionsRequestDTO);
}
