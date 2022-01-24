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
@Table(name="lotto_number_percent")
public class LOTTO_NUMBER_PERCENT {

    @Id
    public int NUMBER;
    public double PERCENT;
}
