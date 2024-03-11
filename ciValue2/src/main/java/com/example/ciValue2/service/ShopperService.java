package com.example.ciValue2.service;


import java.util.List;

import com.example.ciValue2.entity.Shopper;

public interface ShopperService {
    Shopper getShopperById(Long shopperId);
    Shopper createShopper(Shopper shopper);
    Shopper updateShopper(Long shopperId, Shopper shopper);
	void deleteShopper(Long shopperId);
	Shopper createShopper(Long productId, double relevancyScore);
    
}
