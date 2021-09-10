package persnal.practice.lotto.lotto.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import persnal.practice.lotto.commons.domain.LottoNumberRepository;
import persnal.practice.lotto.lotto.entity.LOTTO_NUMBER;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UpdateNewLottoNumberServiceTests {

    @Mock
    private LottoNumberRepository lottoNumberRepository;

    @Test
    public void create(){
        LOTTO_NUMBER lottoNumber =
                LOTTO_NUMBER.builder()
                        .ROUND(0)
                        .NUMBER1(1)
                        .NUMBER2(2)
                        .NUMBER3(3)
                        .NUMBER4(4)
                        .NUMBER5(5)
                        .NUMBER6(6)
                        .BONUS(7)
                        .build();

        lottoNumberRepository.save(lottoNumber);
    }

}