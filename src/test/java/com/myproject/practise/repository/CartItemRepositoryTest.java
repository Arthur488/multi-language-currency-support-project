package com.myproject.practise.repository;

import com.myproject.practise.entity.Customer;
import com.myproject.practise.entity.Item;
import com.myproject.practise.entity.Product2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class CartItemRepositoryTest {

    @Autowired
    private CartItemRepository itemRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testCreateCartItem() {

        Product2 product = entityManager.find(Product2.class, 1);
        Customer customer = entityManager.find(Customer.class, 1);
        Integer quantity = 3;

        Item item = new Item(product, customer, quantity);

        itemRepository.save(item);

    }

    @Test
    void testCreateTwoCartItems() {
        Item item1 = new Item(new Product2(2), new Customer(2), 5);
        Item item2 = new Item(new Product2(3), new Customer(3), 7);
        itemRepository.saveAll(List.of(item1, item2));
    }

    @Test
    void testGetItemByProduct() {
        List <Item> itemList = itemRepository.findByProduct(new Product2(1));
        itemList.forEach(System.out::println);
    }

    @Test
    void testGetItemByCustomer() {
        List <Item> itemList = itemRepository.findByCustomer(new Customer(1));
        itemList.forEach(System.out::println);
    }
}