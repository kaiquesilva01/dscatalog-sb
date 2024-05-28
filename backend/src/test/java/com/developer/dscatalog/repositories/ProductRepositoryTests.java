package com.developer.dscatalog.repositories;

import com.developer.dscatalog.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    @Test
    public void deleteShouldDelectObjectWhenIdExists() {
        repository.deleteById(1L);

        Optional<Product> result = repository.findById(1L);

        Assertions.assertFalse(result.isPresent());
    }
}
