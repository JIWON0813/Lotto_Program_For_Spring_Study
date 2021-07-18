package persnal.practice.lotto.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class UpdateNewLottoNumberService {

    public void insertNewLottoNumber(){
        StringBuilder url = new StringBuilder();
        url.append("https://www.dhlottery.co.kr/gameResult.do?method=byWin&drwNo=");
        String round = "";
        url.append(round);
        Document document = null;
        try {
            document = Jsoup.connect(url.toString()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Elements elements = document.select("[id=dwrNoList]");
    }
}
