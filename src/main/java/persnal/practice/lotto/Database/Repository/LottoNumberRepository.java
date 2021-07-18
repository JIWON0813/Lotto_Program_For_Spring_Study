package persnal.practice.lotto.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persnal.practice.lotto.Database.Entity.LottoNumber;

public interface LottoNumberRepository extends JpaRepository<LottoNumber , Long> {
}
