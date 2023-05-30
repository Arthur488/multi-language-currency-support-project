package com.myproject.products.dao;

import com.myproject.products.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    // Можете добавить методы для получения товаров на основе языка, например:
    List<Product> findAllByNameEn(String nameEn);
    List<Product> findAllByNameRu(String nameRu);

}
