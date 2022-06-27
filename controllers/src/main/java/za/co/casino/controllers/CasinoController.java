package za.co.casino.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.casino.model.dto.BalanceUpdateRequestDTO;
import za.co.casino.model.dto.TransactionsRequestDTO;
import za.co.casino.service.CasinoService;

@RestController
@RequestMapping(value = "/casino")
@RequiredArgsConstructor
public class CasinoController {

    private final CasinoService casinoService;

    @GetMapping(value = "/player/{playerid}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBalance(@PathVariable(value="playerid") int playerId){
      return casinoService.getPlayerInfo(playerId);
    }

    @PostMapping(value = "/player/{playerid}/balance/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePlayerBalance(@PathVariable(value="playerid") int playerId,
                                     @RequestBody BalanceUpdateRequestDTO balanceUpdateRequestDTO){
        return casinoService.updatePlayerBalance(playerId, balanceUpdateRequestDTO);
    }

    @PostMapping(value = "/admin/player/transactions",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPlayerTransactions(
                                              @RequestBody TransactionsRequestDTO transactionsRequestDTO){
        return casinoService.getPlayerTransactions(transactionsRequestDTO);
    }

}
