package persnal.practice.lotto.commons.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import persnal.practice.lotto.lotto.domain.entity.LOTTO_NUMBER;

public interface LottoNumberRepository extends JpaRepository<LOTTO_NUMBER, Long> {

    @Query("SELECT MAX(ROUND) FROM LOTTO_NUMBER")
    String getMaxRound();
}
