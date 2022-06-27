package za.co.casino.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.casino.common.enums.TransactionType;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceUpdateRequestDTO implements Serializable {

    private BigDecimal amount;
    private TransactionType transactionType;
}
