package com.myproject.products.dao;

import com.myproject.products.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreate6products(){
        Product product1 = new Product("Iphone 5", "Айфон 5", "Not bad phone", "Не плохая мобила");
        Product product2 = new Product("Iphone 6", "Айфон 6", "Fine phone", "Порядочная мобила");
        Product product3 = new Product("Iphone 7", "Айфон 7", "OK phone", "Нормальная мобила");
        Product product4 = new Product("Iphone 8", "Айфон 8", "Cool phone", "Крутая мобила");
        Product product5 = new Product("Iphone X", "Айфон X", "Good phone", "Хорошая мобила");
        Product product6= new Product("Iphone Xr", "Айфон Xr", "Excellent phone", "Идеальная мобила");
        List<Product> productList = List.of(product1, product2, product3, product4, product5, product6);

        List<Product> savedProductsList = (List <Product>) productRepository.saveAll(productList);
        savedProductsList.forEach(System.out::println);

        assertThat(savedProductsList).size().isGreaterThan(0);
    }

    @Test
    public void testGetAllEng(){
        List <Product> productsEng = (List <Product>) productRepository.findAll();
        for (Product product: productsEng) {
            System.out.println(product.getId());
        }
    }
//
//    @Test
//    public void testGetAllRus(){
//        List <Product> productsRus = productRepository.findAllProductsRus();
//        for (Product product: productsRus) {
//
//        }
//    }



}