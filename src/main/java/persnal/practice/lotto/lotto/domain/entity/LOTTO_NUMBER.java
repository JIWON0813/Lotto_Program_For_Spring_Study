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

    public String NUMBER1;
    public String NUMBER2;
    public String NUMBER3;
    public String NUMBER4;
    public String NUMBER5;
    public String NUMBER6;
    public String BONUS;
}
