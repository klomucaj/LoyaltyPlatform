package it.unicam.cs.ids.loyaltyPlatform.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public Iterable<Shop> getAllShops(){
        return this.shopRepository.findAll();
    }

    public Shop createShop(Shop shop){
        return this.shopRepository.save(shop);
    }

    public ResponseEntity<Shop> getShop(Long id){
        try{
            return new ResponseEntity<>(this.shopRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(new Shop(), HttpStatus.NOT_FOUND);
        }
    }



}