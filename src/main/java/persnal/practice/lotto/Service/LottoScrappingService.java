package persnal.practice.lotto.Service;

import Core.StringBuilderPool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Service
public class LottoScrappingService {

    public Document getLottoPage(){
        StringBuilder url = StringBuilderPool.take();
        url.append("https://www.dhlottery.co.kr/gameResult.do?method=byWin&drwNo=");
        String round = "";
        url.append(round);
        Document document = null;
        try {
            document = Jsoup.connect(url.toString()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return document;
    }

    public String getLatestNumber(){
        Document document = this.getLottoPage();

        Elements elements = document.select("[id=dwrNoList]");

        String number = elements.select("select option[selected]").text();

        return number;
    }

    public String[] getLottoNumberByRound(String round){

        return null;
    }
}
