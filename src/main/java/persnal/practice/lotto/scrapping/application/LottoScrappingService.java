package persnal.practice.lotto.scrapping.application;

import org.jsoup.nodes.Element;
import persnal.practice.lotto.commons.core.StringBuilderPool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class LottoScrappingService {

    public Document getLottoPage(){
        StringBuilder url = StringBuilderPool.take();
        url.append("https://www.dhlottery.co.kr/gameResult.do?method=byWin&drwNo=");
        String round = "";
        url.append(round);
        Document document = null;
        try {
            document = Jsoup.connect(StringBuilderPool.getString(url)).get();
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

    public LinkedList<String> getLottoNumberByRound(String round){
        StringBuilder url = StringBuilderPool.take();
        url.append("https://www.dhlottery.co.kr/gameResult.do?method=byWin&drwNo=");
        url.append(round);
        Document document = null;
        try {
            document = Jsoup.connect(StringBuilderPool.getString(url)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Element winNumber = document.selectFirst("div[class=num win]");
        Elements numbers = winNumber.select("span[class*=ball_645]");
        LinkedList<String> number = new LinkedList<>();
        numbers.forEach(element -> {
            number.add(element.text());
        });

        String bonusNumber = document.selectFirst("div[class=num bonus]").selectFirst("span[class*=ball_645]").text();

        number.add(bonusNumber);

        return number;
    }
}
