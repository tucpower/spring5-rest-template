package com.giannopoulos.spring5.rest.template.bootstrap;

import com.giannopoulos.spring5.rest.template.domain.Customer;
import com.giannopoulos.spring5.rest.template.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Customer Data");

        Customer c1 = new Customer();
        c1.setFirstName("Michael");
        c1.setLastName("Jackson");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstName("Sam");
        c2.setLastName("Axe");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setFirstName("Fiona");
        c3.setLastName("Doe");
        customerRepository.save(c3);

        System.out.println("Customers saved: " + customerRepository.count());
    }
}
