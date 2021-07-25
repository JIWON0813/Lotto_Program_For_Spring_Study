package persnal.practice.lotto.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import persnal.practice.lotto.Database.Entity.LOTTO_NUMBER;

public interface LottoNumberRepository extends JpaRepository<LOTTO_NUMBER, Long> {

    @Query("SELECT MAX(ROUND) FROM LOTTO_NUMBER")
    String getMaxRound();
}
