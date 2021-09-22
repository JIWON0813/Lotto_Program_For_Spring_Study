package persnal.practice.lotto.lotto.application;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import persnal.practice.lotto.commons.domain.LottoNumberRepository;
import persnal.practice.lotto.lotto.entity.LOTTO_NUMBER;
import persnal.practice.lotto.scrapping.application.LottoScrappingService;

import java.util.LinkedList;
import java.util.stream.IntStream;

@Service
public class UpdateNewLottoNumberService {

    @Autowired
    LottoNumberRepository lottoNumberRepository;

    @Autowired
    LottoScrappingService lottoScrappingService;

    @EventListener(ContextRefreshedEvent.class)
    public void autoUpdateNewRound(){
        Document document = lottoScrappingService.getLottoPage();

        Elements elements = document.select("[id=dwrNoList]");

        int latestRoundFromWeb = Integer.parseInt(elements.select("select option[selected]").text());

        int latestRoundFromData = 1;
        latestRoundFromData = Integer.parseInt(this.GetLatestRound());

        //DB 번호 최신화
        IntStream.range(latestRoundFromData , latestRoundFromWeb).forEach(num -> {
            LinkedList<String> listByRound = lottoScrappingService.getLottoNumberByRound(String.valueOf(num));
            LOTTO_NUMBER lottoNumberByRound = LOTTO_NUMBER.builder()
                                                            .ROUND(num)
                                                            .NUMBER1(listByRound.indexOf(0))
                                                            .NUMBER2(listByRound.indexOf(1))
                                                            .NUMBER3(listByRound.indexOf(2))
                                                            .NUMBER4(listByRound.indexOf(3))
                                                            .NUMBER5(listByRound.indexOf(4))
                                                            .NUMBER6(listByRound.indexOf(5))
                                                            .BONUS(listByRound.indexOf(6))
                                                            .build();
            this.insertLottoNumber(lottoNumberByRound);
        });

    }

    @Transactional
    public void insertLottoNumber(LOTTO_NUMBER lottoNumber){
        lottoNumberRepository.save(lottoNumber);
    }

    public String GetLatestRound(){
        return lottoNumberRepository.getMaxRound();
    }
}
