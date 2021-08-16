package persnal.practice.lotto.Service;

import Core.StringBuilderPool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persnal.practice.lotto.Database.Repository.LottoNumberRepository;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class UpdateNewLottoNumberService {

    @Autowired
    LottoNumberRepository lottoNumberRepository;

    @Autowired
    LottoScrappingService lottoScrappingService;

    public void autoUpdateNewRound(){
        Document document = lottoScrappingService.getLottoPage();

        Elements elements = document.select("[id=dwrNoList]");

        int latestRoundFromWeb = Integer.parseInt(elements.select("select option[selected]").text());

        int latestRoundFromData = 1;
        latestRoundFromData = Integer.parseInt(this.GetLatestRound());

        //DB 번호 최신화
        IntStream.range(latestRoundFromData , latestRoundFromWeb).forEach(num -> {

        });

    }

    public int insertLottoNumber(){
        int result = 0;

        return result;
    }

    public String GetLatestRound(){
        return lottoNumberRepository.getMaxRound();
    }
}
