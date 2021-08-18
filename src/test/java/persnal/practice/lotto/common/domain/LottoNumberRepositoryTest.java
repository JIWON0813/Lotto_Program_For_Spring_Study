package persnal.practice.lotto.common.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import persnal.practice.lotto.commons.domain.LottoNumberRepository;
import persnal.practice.lotto.commons.dto.LOTTO_NUMBER;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class LottoNumberRepositoryTest {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/lotto?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul";
    private static final String ID = "root";
    private static final String PASSWORD = "1331";

    @Autowired
    private LottoNumberRepository lottoNumberRepository;

    @Test
    public void testConnection() throws Exception{
        Class.forName(DRIVER);

        try(Connection connection = DriverManager.getConnection(URL,ID,PASSWORD)){
            System.out.println(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void create(){
        LOTTO_NUMBER lottoNumber =
                LOTTO_NUMBER.builder()
                        .ROUND(1)
                        .NUMBER1(1)
                        .NUMBER2(2)
                        .NUMBER3(3)
                        .NUMBER4(4)
                        .NUMBER5(5)
                        .NUMBER6(6)
                        .BONUS(7)
                .build();

        LOTTO_NUMBER newLotto = lottoNumberRepository.save(lottoNumber);
        //log.info(newLotto.toString());
    }

    @Test
    public void GetLatestRound(){
        System.out.println(lottoNumberRepository.getMaxRound());
    }
}