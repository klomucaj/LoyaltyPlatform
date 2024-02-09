package it.unicam.cs.ids.loyaltyPlatform.bonus;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BonusRepository extends CrudRepository<Bonus, Long> {

    @Query(value =
            "SELECT" +
            "* FROM bonus " +
            "WHERE loyalty_program_id = :id", nativeQuery = true)
    List<Bonus> findBonusByLoyaltyProgramID(Long id);

}
