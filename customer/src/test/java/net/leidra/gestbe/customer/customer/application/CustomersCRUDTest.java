package net.leidra.gestbe.customer.customer.application;

import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc.JdbcCustomersRepository;
import net.leidra.gestbe.testcontainer.PostgreSQLITContainer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import static net.leidra.gestbe.customer.customer.domain.model.CustomerMother.randomCustomer;
import static net.leidra.gestbe.customer.customer.domain.model.CustomerMother.randomCustomerName;
import static org.assertj.core.api.Assertions.assertThat;

@Import({JdbcCustomersRepository.class})
class CustomersCRUDTest extends PostgreSQLITContainer {

    private CustomerSearcher customerSearcher;
    private CustomerSaver customerSaver;
    private CustomerRemover customerRemover;

    @Autowired
    private JdbcCustomersRepository repository;

    @BeforeEach
    void setUp() {
        customerSearcher = new CustomerSearcher(repository);
        customerSaver = new CustomerSaver(repository);
        customerRemover = new CustomerRemover(repository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_create_modify_and_remove_a_customer() {
        final Customer customer = randomCustomer();
        customerSaver.save(customer.id().id(), customer.name().name());
        assertThat(repository.existsById(customer.id())).isTrue();

        customerSaver.save(customer.id().id(), randomCustomerName().name());

        assertThat(customerSearcher.searchById(customer.id().id())).isNotEmpty();

        customerRemover.removeById(customer.id().id());
        assertThat(repository.existsById(customer.id())).isFalse();
    }

}
