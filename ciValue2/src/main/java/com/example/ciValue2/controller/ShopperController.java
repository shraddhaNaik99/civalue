package com.example.ciValue2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ciValue2.entity.Shopper;
import com.example.ciValue2.service.ShopperService;

import java.util.List;

@RestController
@RequestMapping("/api/shoppers")
public class ShopperController {
    private final ShopperService shopperService;

    @Autowired
    public ShopperController(ShopperService shopperService) {
        this.shopperService = shopperService;
    }

    @GetMapping("/{shopperId}")
    public ResponseEntity<Shopper> getShopperById(@PathVariable Long shopperId) {
        Shopper shopper = shopperService.getShopperById(shopperId);
        return ResponseEntity.ok(shopper);
    }

     
    @PostMapping
    public ResponseEntity<Shopper> createShopper(@RequestBody Shopper shopper) {
        Shopper createdShopper = shopperService.createShopper(shopper);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShopper);
    }

    @PutMapping("/{shopperId}")
    public ResponseEntity<Shopper> updateShopper(@PathVariable Long shopperId, @RequestBody Shopper shopper) {
        Shopper updatedShopper = shopperService.updateShopper(shopperId, shopper);
        return ResponseEntity.ok(updatedShopper);
    }

    @DeleteMapping("/{shopperId}")
    public ResponseEntity<Void> deleteShopper(@PathVariable Long shopperId) {
        try {
            shopperService.deleteShopper(shopperId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
