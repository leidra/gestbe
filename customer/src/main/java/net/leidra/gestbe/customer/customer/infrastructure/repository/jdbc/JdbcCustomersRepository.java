package net.leidra.gestbe.customer.customer.infrastructure.repository.jdbc;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.customer.domain.repository.CustomersRepository;
import net.leidra.gestbe.customer.customer.infrastructure.model.jdbc.JdbcCustomer;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public final class JdbcCustomersRepository implements CustomersRepository {
    public static final String FIND_ALL_QUERY = "SELECT id, name, created_on, updated_on FROM customer";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Stream<Customer> findAll() {
        final DataClassRowMapper<JdbcCustomer> rowMapper = DataClassRowMapper.newInstance(JdbcCustomer.class);
        final Map<String, Object> paramMap = Map.of();
        return jdbcTemplate.queryForStream(FIND_ALL_QUERY, paramMap, rowMapper)
                .map(JdbcCustomer::toCustomer);
    }
}
