package za.co.casino.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import za.co.casino.common.enums.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@Table(name = "transaction_information")
public class TransactionInformation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @SequenceGenerator(name="generator", sequenceName="id_seq", allocationSize = 1)
    private int id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "player_information_id", nullable = false)
    private PlayerInformation playerInformation;

}
