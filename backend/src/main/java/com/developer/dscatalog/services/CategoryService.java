package com.developer.dscatalog.services;

import com.developer.dscatalog.dto.CategoryDTO;
import com.developer.dscatalog.entities.Category;
import com.developer.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository  categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll () {
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }
}
