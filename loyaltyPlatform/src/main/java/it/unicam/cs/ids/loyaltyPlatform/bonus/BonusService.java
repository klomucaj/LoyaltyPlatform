package it.unicam.cs.ids.loyaltyPlatform.bonus;


import it.unicam.cs.ids.loyaltyPlatform.loyaltyProgram.LoyaltyProgramService;
import it.unicam.cs.ids.loyaltyPlatform.subscription.SubscriptionService;

import org.springframework.stereotype.Service;



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



}
