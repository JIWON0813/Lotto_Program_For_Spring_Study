package persnal.practice.lotto.Service;

import org.junit.Test;
import persnal.practice.lotto.Controller.TestController;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LottoScrappingServiceTest {

    LottoScrappingService lottoScrappingService = new LottoScrappingService();

    @Test
    public void testGetLatestNum(){
        String number = lottoScrappingService.getLatestNumber();
        assertThat(number, is("975"));
    }
}