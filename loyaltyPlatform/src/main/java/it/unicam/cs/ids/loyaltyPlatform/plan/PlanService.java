package it.unicam.cs.ids.loyaltyPlatform.plan;

import it.unicam.cs.ids.loyaltyPlatform.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public PlanService(){
    }

    public Iterable<Plan> getAllPlans(){
        return this.planRepository.findAll();
    }

    public ResponseEntity<Plan> getPlan(Long campaign){
        try{
            return new ResponseEntity<>(this.planRepository.findById(campaign).orElseThrow(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(new Plan(), HttpStatus.NOT_FOUND);
        }
    }

    public void deletePlan(Long campaign){
        this.planRepository.deleteById(campaign);
    }


}
