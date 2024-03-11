package com.example.ciValue2.dto;

import com.example.ciValue2.entity.Product;


import lombok.Data;

@Data
public class ShopperDto {
	private Long shopperId;

    private Product product;

    private double relevancyScore;

   
    
}


