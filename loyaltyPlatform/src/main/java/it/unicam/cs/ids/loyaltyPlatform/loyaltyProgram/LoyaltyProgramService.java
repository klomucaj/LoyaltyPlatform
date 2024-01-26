package it.unicam.cs.ids.loyaltyPlatform.loyaltyProgram;

import it.unicam.cs.ids.loyaltyPlatform.customDTOs.BonusCreationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LoyaltyProgramService {
    private final LoyaltyProgramRepository loyaltyProgramRepository;

    public LoyaltyProgramService(LoyaltyProgramRepository loyaltyProgramRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
    }


    public Optional<LoyaltyProgram> getLoyaltyProgram(Long loyaltyProgramID) {
        return this.loyaltyProgramRepository.findById(loyaltyProgramID);
    }

    public List<LoyaltyProgram> getAllLoyaltyPrograms() {
        Iterable<LoyaltyProgram> itr = loyaltyProgramRepository.findAll();
        return StreamSupport.stream(itr.spliterator(), false).collect(Collectors.toList());
    }

}
