package it.unicam.cs.ids.loyaltyPlatform.loyaltyProgram.programRatio;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity(name = "ratios")
@Data
public class ProgramRatio{

    @Id
    @GeneratedValue(generator = "ratios_id_generator",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ratios_id_generator")
    @Column(name = "ratio_id", nullable = false)
    private Long id;

    private int benefitToExpensePercentage;

    @Column(name = "ratioParameter")
    @Enumerated(EnumType.STRING)
    private ProgramRatioParameter parameter;

    @Column(name = "ratioParameterDiscountPercentage")
    private int parameterValueOfDiscountInPercentage;

    @Column(name = "categoryAppliedTo")
    private String categoryApplicableTo;

    @Temporal(TemporalType.DATE)
    private LocalDate applicableDate;

}