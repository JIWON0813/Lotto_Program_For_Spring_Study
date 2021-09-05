package persnal.practice.lotto.scrapping.application;

import org.junit.Test;
import persnal.practice.lotto.scrapping.application.LottoScrappingService;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LottoScrappingServiceTest {

    LottoScrappingService lottoScrappingService = new LottoScrappingService();

    @Test
    public void testGetLatestRound(){
        String number = lottoScrappingService.getLatestNumber();
        assertThat(number, is("975"));
    }

    @Test
    public void testGetLottoNumberByRound(){
        LinkedList<?> number = lottoScrappingService.getLottoNumberByRound("975");
        System.out.println(number.toString());
        assertThat(number.toString(), is("[]"));
    }
}