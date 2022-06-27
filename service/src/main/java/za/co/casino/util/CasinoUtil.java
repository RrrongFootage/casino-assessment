package za.co.casino.util;

import za.co.casino.persistence.entity.PlayerInformation;

import java.math.BigDecimal;

public class CasinoUtil {

    public static void addBalanceAmount(PlayerInformation playerInformation, BigDecimal value){
        playerInformation.setBalance(
                playerInformation.getBalance()
                        .add(value));
    }

    public static void subtractBalanceAmount(PlayerInformation playerInformation, BigDecimal value){
        playerInformation.setBalance(
                playerInformation.getBalance()
                        .subtract(value));
    }
}
