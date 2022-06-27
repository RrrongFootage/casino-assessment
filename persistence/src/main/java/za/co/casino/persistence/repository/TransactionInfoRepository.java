package za.co.casino.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.casino.persistence.entity.TransactionInformation;

import java.util.List;

@Repository
public interface TransactionInfoRepository extends JpaRepository<TransactionInformation, Integer> {

    List<TransactionInformation> findTop10TransactionInformationByPlayerInformation_UsernameOrderByIdDesc(String username);

}
