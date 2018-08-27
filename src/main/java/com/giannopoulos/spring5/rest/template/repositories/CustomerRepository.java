package com.giannopoulos.spring5.rest.template.repositories;

import com.giannopoulos.spring5.rest.template.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
