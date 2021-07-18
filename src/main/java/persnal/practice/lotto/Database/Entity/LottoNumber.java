package persnal.practice.lotto.Database.Entity;

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
public class LottoNumber {

    @Id
    public int Round;

    public int Number1;
    public int Number2;
    public int Number3;
    public int Number4;
    public int Number5;
    public int Number6;
    public int Bonus;
}
