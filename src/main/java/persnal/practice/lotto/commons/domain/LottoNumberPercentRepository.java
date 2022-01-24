package persnal.practice.lotto.commons.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import persnal.practice.lotto.lotto.domain.entity.LOTTO_NUMBER_PERCENT;

public interface LottoNumberPercentRepository extends JpaRepository<LOTTO_NUMBER_PERCENT, Long> {

}
