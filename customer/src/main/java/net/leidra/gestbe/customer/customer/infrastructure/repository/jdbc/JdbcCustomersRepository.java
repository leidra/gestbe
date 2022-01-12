package net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.domain.repository.CustomersRepository;
import net.leidra.gestbe.customer.customer.infrastructure.model.jdbc.JdbcCustomer;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public final class JdbcCustomersRepository implements CustomersRepository {
    public static final String FIND_ALL_QUERY = "SELECT id, name, created_on, updated_on FROM customer";
    public static final String FIND_BY_ID_QUERY = "SELECT id, name, created_on, updated_on FROM customer WHERE id = :id";
    public static final String EXISTS_BY_ID_QUERY = "SELECT EXISTS(SELECT 1 FROM customer WHERE id = :id)";
    private static final String INSERT_QUERY = "INSERT INTO customer(id, name, created_on, updated_on) VALUES(:id, :name, :createdOn, :updatedOn)";
    private static final String UPDATE_QUERY = "UPDATE customer SET name = :name, created_on = :createdOn, updated_on = :updatedOn WHERE id = :id";
    public static final String DELETE_BY_ID = "DELETE FROM customer WHERE id = :id";

    public static final DataClassRowMapper<JdbcCustomer> ROW_MAPPER = DataClassRowMapper.newInstance(JdbcCustomer.class);

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Stream<Customer> findAll() {
        return jdbcTemplate.queryForStream(FIND_ALL_QUERY, Map.of(), ROW_MAPPER)
                .map(JdbcCustomer::toCustomer);
    }

    @Override
    public Optional<Customer> findById(final CustomerId customerId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, Map.of("id", customerId.id()), ROW_MAPPER))
                .map(JdbcCustomer::toCustomer);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Boolean existsById(final CustomerId customerId) {
        return jdbcTemplate.queryForObject(EXISTS_BY_ID_QUERY, Map.of("id", customerId.id()), Boolean.class);
    }

    @Override
    public void save(final Customer customer) {
        String query = INSERT_QUERY;
        if(existsById(customer.id())) {
            query = UPDATE_QUERY;
        }
        jdbcTemplate.update(query, new BeanPropertySqlParameterSource(JdbcCustomer.fromCustomer(customer)));
    }

    @Override
    public void deleteById(final CustomerId customerId) {
        jdbcTemplate.update(DELETE_BY_ID, Map.of("id", customerId.id()));
    }
}
