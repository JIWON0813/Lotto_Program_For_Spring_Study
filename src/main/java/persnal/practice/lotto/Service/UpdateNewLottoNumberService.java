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

        int latestRoundinData = 1;
        latestRoundinData = Integer.parseInt(GetLatestRound());

    }

    public String GetLatestRound(){
        return lottoNumberRepository.getMaxRound();
    }
}
