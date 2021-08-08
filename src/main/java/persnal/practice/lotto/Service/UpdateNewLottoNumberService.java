package persnal.practice.lotto.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persnal.practice.lotto.Database.Repository.LottoNumberRepository;

@Service
public class UpdateNewLottoNumberService {

    @Autowired
    LottoNumberRepository lottoNumberRepository;

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

        int num = Integer.parseInt(elements.select("select option[selected]").text());

        int latestRoundFromData = 1;
        latestRoundFromData = Integer.parseInt(GetLatestRound());

        for(int i = latestRoundFromData ; i < num ; i++){
            //값 넣기
        }
    }

    public String GetLatestRound(){
        return lottoNumberRepository.getMaxRound();
    }
}
