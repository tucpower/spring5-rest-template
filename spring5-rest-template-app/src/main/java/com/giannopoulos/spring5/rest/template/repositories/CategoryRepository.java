package com.giannopoulos.spring5.rest.template.repositories;

import com.giannopoulos.spring5.rest.template.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
