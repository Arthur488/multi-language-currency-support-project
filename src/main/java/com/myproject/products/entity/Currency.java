package com.myproject.products.entity;

import lombok.Data;

@Data
public class Currency {

    private String ccy;

    private String base_ccy;

    private Double buy;

    private Double sale;

}
