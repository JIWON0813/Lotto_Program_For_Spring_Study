package persnal.practice.lotto.test;

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
}
