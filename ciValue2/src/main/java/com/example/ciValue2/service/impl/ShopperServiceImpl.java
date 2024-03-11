package com.example.ciValue2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ciValue2.entity.Product;
import com.example.ciValue2.entity.Shopper;
import com.example.ciValue2.repository.ProductRepository;
import com.example.ciValue2.repository.ShopperRepository;
import com.example.ciValue2.service.ShopperService;

@Service
public class ShopperServiceImpl implements ShopperService {

    @Autowired
    private ShopperRepository shopperRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Shopper getShopperById(Long shopperId) {
        return shopperRepository.findById(shopperId)
                .orElseThrow(() -> new RuntimeException("Shopper not found with id: " + shopperId));
    }

   
	@Override
    public Shopper createShopper(Long productId, double relevancyScore) {
        // Fetch the product from the database using productId
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        // Create a new Shopper object
        Shopper shopper = new Shopper();

        // Set the relevant fields
        shopper.setProduct(product);
        shopper.setRelevancyScore(relevancyScore);

        // Save the Shopper object
        return shopperRepository.save(shopper);
    }

    @Override
    public Shopper updateShopper(Long shopperId, Shopper shopper) {
        if (!shopperRepository.existsById(shopperId)) {
            throw new RuntimeException("Shopper not found with id: " + shopperId);
        }
        shopper.setShopperId(shopperId);
        return shopperRepository.save(shopper);
    }

    @Override
    public void deleteShopper(Long shopperId) {
        if (shopperRepository.existsById(shopperId)) {
            shopperRepository.deleteById(shopperId);
        } else {
            throw new RuntimeException("Shopper not found with id: " + shopperId);
        }
    }

	@Override
	public Shopper createShopper(Shopper shopper) {
		// TODO Auto-generated method stub
		return null;
	}
}
