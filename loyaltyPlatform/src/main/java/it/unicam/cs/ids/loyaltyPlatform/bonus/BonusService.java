package it.unicam.cs.ids.loyaltyPlatform.bonus;

import it.unicam.cs.ids.loyaltyPlatform.loyaltyProgram.LoyaltyProgram;
import it.unicam.cs.ids.loyaltyPlatform.loyaltyProgram.LoyaltyProgramService;
import it.unicam.cs.ids.loyaltyPlatform.subscription.SubscriptionService;
import it.unicam.cs.ids.loyaltyPlatform.supermaketCashRegisterSimulator.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BonusService{
    private final LoyaltyProgramService loyaltyProgramService;
    private final SubscriptionService subscriptionService;
    private final BonusRepository bonusRepository;

    public BonusService(LoyaltyProgramService loyaltyProgramService, SubscriptionService subscriptionService, BonusRepository bonusRepository) {
        this.loyaltyProgramService = loyaltyProgramService;
        this.subscriptionService = subscriptionService;
        this.bonusRepository = bonusRepository;
    }


    /**
     * Applies bonuses to products to determine the final price of the product.
     * @param loyaltyProgramID program id.
     * @param products products from the shop.
     * @return the new value of the total cost.
     */
    public float applyBonus(Long loyaltyProgramID, List<Product> products){
        return (float) this.extractBonusFromProgram(loyaltyProgramID).stream()
                .flatMap(bonus -> products.stream().map(product -> applyDiscount(product, bonus)))
                .mapToDouble(Float::doubleValue)
                .sum();
    }

    /**
     * It creates a Set of bonuses from the given {@link LoyaltyProgram} ID if it exists.
     * It then sets the bonus's ID to that of the program it is created from.
     * @param programID LoyaltyProgram ID.
     * @return a Set of Bonuses if the LoyaltyProgram exists. Else null.
     */
    private Set<Bonus> extractBonusFromProgram(Long programID) {

        Set<Bonus> bonuses = new HashSet<>();
        loyaltyProgramService.getBonusCreationDTOsFromProgram(programID).forEach(dto -> {
            Bonus bonus = new Bonus(dto.getDiscountPercentage() / 100F,
                            dto.getBenefit()/100F,
                            dto.getDate(), dto.getCategory());
            bonus.setLoyaltyProgramID(programID);
            bonuses.add(bonus);
        });
        return bonuses;
    }

    /**
     * It applies the discounts on a bonus to a product.
     * When I complete the proper settings it will filter by category or product id too.
     * @param product product to apply bonus on.
     * @param bonus bonus to apply on product.
     * @return the new price value.
     */
    private float applyDiscount(Product product, Bonus bonus) {

        if(product.getCategory().getCategory().equals(bonus.getItemCategoryTag())
                && bonus.getBonusApplicableDate()==null ||
                (bonus.getBonusApplicableDate()!=null && bonus.getBonusApplicableDate().equals(LocalDate.now())))
            return product.getPrice() - (bonus.getDiscountPercentage() * product.getPrice());
        return product.getPrice();
    }
    private void deleteBonuses(Long programID){
        bonusRepository.deleteAll(bonusRepository.findBonusByLoyaltyProgramID(programID));
    }
}
