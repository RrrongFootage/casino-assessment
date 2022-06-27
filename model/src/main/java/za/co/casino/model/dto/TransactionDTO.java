package za.co.casino.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.casino.common.enums.TransactionType;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Integer transactionId;
    private BigDecimal amount;
    private TransactionType transactionType;
}
