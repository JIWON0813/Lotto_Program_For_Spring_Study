package persnal.practice.lotto.Database.Repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import persnal.practice.lotto.Database.Entity.LottoNumber;

import static org.junit.Assert.*;

@Slf4j
public class LottoNumberRepositoryTest {

    @Autowired
    private LottoNumberRepository lottoNumberRepository;

    @Test
    public void create(){
        LottoNumber lottoNumber =
                LottoNumber.builder()
                        .Round(1)
                        .Number1(1)
                        .Number2(2)
                        .Number3(3)
                        .Number4(4)
                        .Number5(5)
                        .Number6(6)
                        .Bonus(7)
                .build();

        LottoNumber newLotto = lottoNumberRepository.save(lottoNumber);
        log.info(newLotto.toString());
    }
}