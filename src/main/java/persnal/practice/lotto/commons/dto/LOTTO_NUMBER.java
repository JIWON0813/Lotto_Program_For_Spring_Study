package persnal.practice.lotto.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
