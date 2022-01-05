package net.leidra.gestbe.customer.customer.application;

import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc.JdbcCustomersRepository;
import net.leidra.gestbe.testcontainer.PostgreSQLITContainer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;

import static net.leidra.gestbe.customer.customer.domain.model.CustomerMother.*;
import static org.assertj.core.api.Assertions.assertThat;

@Import({JdbcCustomersRepository.class})
class CustomersCRUDTest extends PostgreSQLITContainer {

    private CustomersSearcher customersSearcher;
    private CustomersSaver customersSaver;
    private CustomersRemover customersRemover;

    @Autowired
    private JdbcCustomersRepository repository;

    @BeforeEach
    void setUp() {
        customersSearcher = new CustomersSearcher(repository);
        customersSaver = new CustomersSaver(repository);
        customersRemover = new CustomersRemover(repository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_find_all_customers() {
        List<Customer> expectedCustomers = repository.findAll().toList();
        List<Customer> actualCustomers = customersSearcher.searchAll().toList();

        assertThat(actualCustomers).isEqualTo(expectedCustomers);
    }

    @Test
    void should_create_modify_and_remove_a_customer() {
        final Customer customer = randomCustomer();
        customersSaver.save(customer.id().id(), customer.name().name(), customer.createdOn().time(), customer.updatedOn().time());
        assertThat(repository.existsById(customer.id())).isTrue();

        customersSaver.save(customer.id().id(), randomCustomerName().name(), randomAuditDateTime().time(), randomAuditDateTime().time());

        assertThat(customersSearcher.searchById(customer.id().id())).isNotEmpty();

        customersRemover.removeById(customer.id().id());
        assertThat(repository.existsById(customer.id())).isFalse();
    }

}
