package com.myproject.products.service;

import com.myproject.products.entity.Product;

import java.util.List;

/**
 * The interface Product service.
 */
public interface IProductService {

    /**
     * Find all list .
     *
     * @return the list
     */
    List <Product> findAll();

    /**
     * Get currency course from api double [ ].
     *
     * @return the double [ ]
     */
    Double[] getCurrencyCourseFromAPI();
}
