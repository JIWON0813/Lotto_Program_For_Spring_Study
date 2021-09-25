package persnal.practice.lotto.lotto.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="lotto_number")
public class LOTTO_NUMBER{

    @Id
    public int ROUND;

    public int NUMBER1;
    public int NUMBER2;
    public int NUMBER3;
    public int NUMBER4;
    public int NUMBER5;
    public int NUMBER6;
    public int BONUS;
}
