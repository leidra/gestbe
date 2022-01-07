package net.leidra.gestbe.customer.customer.infrastructure.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class CustomersResponse extends ArrayList<CustomerResponse> implements Serializable {
    public CustomersResponse() {
    }

    public CustomersResponse(Collection<? extends CustomerResponse> c) {
        super(c);
    }

    public static CustomersResponse fromStream(final Stream<CustomerResponse> customers) {
        return new CustomersResponse(customers.toList());
    }
}
