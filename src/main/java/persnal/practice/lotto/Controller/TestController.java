package persnal.practice.lotto.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @GetMapping("/gettest")
    public HashMap<String, String> getTest(){
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("test", "success test");

        return testMap;
    }

    @GetMapping("/gettestUrl")
    public HashMap<String, String> getTestUrl(){
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("test", "success test");

        StringBuilder url = new StringBuilder();
        url.append("https://www.dhlottery.co.kr/gameResult.do?method=byWin");
        Document document = null;
        try {
            document = Jsoup.connect(url.toString()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        testMap.put("result", document.text());

        return testMap;
    }

    @GetMapping("/getTestLatestNumber")
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
