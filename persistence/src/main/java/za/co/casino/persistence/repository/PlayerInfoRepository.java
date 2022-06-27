package za.co.casino.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.casino.persistence.entity.PlayerInformation;

@Repository
public interface PlayerInfoRepository extends JpaRepository<PlayerInformation, Integer> {

    PlayerInformation findPlayerInformationByUsername(String username);
}
