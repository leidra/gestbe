package net.leidra.gestbe.customer.customer.application;

import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc.JdbcCustomersRepository;
import net.leidra.gestbe.testcontainer.PostgreSQLITContainer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import({JdbcCustomersRepository.class})
class CustomerSearcherTest extends PostgreSQLITContainer {

    private CustomerSearcher customerSearcher;
    @Autowired
    private JdbcCustomersRepository repository;

    @BeforeEach
    void setUp() {
        customerSearcher = new CustomerSearcher(repository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        List<Customer> expectedCustomers = repository.findAll().toList();
        List<Customer> actualCustomers = customerSearcher.searchAll().toList();

        Assertions.assertThat(actualCustomers).isEqualTo(expectedCustomers);
    }
}