package com.developer.dscatalog.repositories;

import com.developer.dscatalog.dto.ProductDTO;
import com.developer.dscatalog.entities.Product;
import com.developer.dscatalog.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    private long existing;
    private long nonExisting;

    private long countTotalProducts;
    @BeforeEach
    void setUp() throws Exception {
        existing = 1L;
        nonExisting = 1000L;
        countTotalProducts = 25L;
    }

    @Test
    public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());
    }

    @Test
    public void findByIdShouldReturnOptionalWhenIdExist() {
        Optional<Product> obj = repository.findById(existing);

        Assertions.assertTrue(obj.isPresent());
    }

    @Test
    public void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExist() {
        Optional<Product> obj = repository.findById(nonExisting);

        Assertions.assertTrue(obj.isEmpty());
    }

    @Test
    public void deleteShouldDelectObjectWhenIdExists() {
        repository.deleteById(existing);

        Optional<Product> result = repository.findById(existing);

        Assertions.assertFalse(result.isPresent());
    }
}
