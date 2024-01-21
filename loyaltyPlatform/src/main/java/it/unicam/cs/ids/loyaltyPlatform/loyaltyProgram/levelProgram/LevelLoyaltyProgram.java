package it.unicam.cs.ids.loyaltyPlatform.loyaltyProgram.levelProgram;

import it.unicam.cs.ids.loyaltyPlatform.loyaltyProgram.LoyaltyProgram;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "levelloyaltyprogram")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LevelLoyaltyProgram extends LoyaltyProgram {

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Level> levels;


}
