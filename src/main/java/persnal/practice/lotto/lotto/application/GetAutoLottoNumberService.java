package persnal.practice.lotto.lotto.application;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import persnal.practice.lotto.commons.domain.LottoNumberRepository;
import persnal.practice.lotto.lotto.domain.entity.LOTTO_NUMBER;
import persnal.practice.lotto.scrapping.application.LottoScrappingService;

import java.util.LinkedList;
import java.util.stream.IntStream;

@Service
public class GetAutoLottoNumberService {

    @Autowired
    LottoNumberRepository lottoNumberRepository;

    public void getAutoLottoNumber(){


    }

    //알고리즘 체크 로직(안될시 재생성)
    public boolean checkLogic(){
        boolean result = false;

        return result;
    }
}
