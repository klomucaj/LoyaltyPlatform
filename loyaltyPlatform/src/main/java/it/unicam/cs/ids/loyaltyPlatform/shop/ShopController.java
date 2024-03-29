package it.unicam.cs.ids.loyaltyPlatform.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shops")
    public Iterable<Shop> getAllShops(){
        return this.shopService.getAllShops();
    }

    @PostMapping("/shops")
    public Shop createShop(@RequestBody Shop shop){
        return this.shopService.createShop(shop);
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable Long id){
        return this.shopService.getShop(id);
    }

    @PutMapping("/shops/{id}")
    public ResponseEntity<Shop> modifyShop(@PathVariable Long id, @RequestBody Shop shop){
        return this.shopService.modifyShop(id, shop);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable Long id){
        return this.shopService.deleteShop(id);
    }

}