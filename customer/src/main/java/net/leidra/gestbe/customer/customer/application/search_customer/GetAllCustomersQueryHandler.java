package net.leidra.gestbe.customer.customer.application.search_customer;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.domain.model.Customer;
import net.leidra.gestbe.customer.shared.application.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
public final class GetAllCustomersQueryHandler implements QueryHandler<GetAllCustomersQuery, Stream<Customer>> {
    private CustomerSearcher searcher;

    @Override
    public Stream<Customer> handle(final GetAllCustomersQuery query) {
        return searcher.searchAll();
    }
}
