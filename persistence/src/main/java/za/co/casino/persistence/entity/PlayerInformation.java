package za.co.casino.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "player_information")
public class PlayerInformation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @SequenceGenerator(name="generator", sequenceName="id_seq", allocationSize = 1)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerInformation")
    private List<TransactionInformation> transactionInformationEntities;

}
