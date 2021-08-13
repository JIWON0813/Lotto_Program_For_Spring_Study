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

    public HashMap<String, String> getTestLatestNumber(){
        HashMap<String, String> testMap = new HashMap<>();

        StringBuilder url = new StringBuilder();
        url.append("https://www.dhlottery.co.kr/gameResult.do?method=byWin");
        Document document = null;
        try {
            document = Jsoup.connect(url.toString()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Elements elements = document.select("[id=dwrNoList]");

        int num = Integer.parseInt(elements.select("select option[selected]").text());

        testMap.put("result", String.valueOf(num));

        return testMap;
    }
}
