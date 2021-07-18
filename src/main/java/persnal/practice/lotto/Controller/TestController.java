package persnal.practice.lotto.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @GetMapping("/gettest")
    public HashMap<String, String> getTset(){
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("test", "success test");

        return testMap;
    }
}
