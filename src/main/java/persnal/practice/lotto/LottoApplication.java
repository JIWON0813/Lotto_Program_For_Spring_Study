package persnal.practice.lotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"persnal.practice.lotto.commons.domain"})
@EntityScan(basePackages = {"persnal.practice.lotto.lotto.domain.entity"})
public class LottoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LottoApplication.class, args);
    }

}
