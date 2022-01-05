package net.leidra.gestbe.customer.customer.domain.model;

import net.leidra.gestbe.shared.domain.model.AuditDateTime;
import net.leidra.gestbe.shared.domain.model.CustomerId;
import net.leidra.gestbe.shared.domain.model.CustomerName;
import org.jeasy.random.EasyRandom;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public final class CustomerMother {
    @NotNull
    public static Customer randomCustomer() {
        return new Customer(randomCustomerId(), randomCustomerName(), randomAuditDateTime(), randomAuditDateTime());
    }

    @NotNull
    public static AuditDateTime randomAuditDateTime() {
        int year = new Random().nextInt(1900, LocalDateTime.now().getYear());
        int month = new Random().nextInt(1, 12);
        int day = new Random().nextInt(1, 28);
        int hour = new Random().nextInt(0, 23);
        int second = new Random().nextInt(0, 59);

        return new AuditDateTime(LocalDateTime.of(year, month, day, hour, second));
    }

    @NotNull
    public static CustomerId randomCustomerId() {
        return new CustomerId(UUID.randomUUID());
    }

    @NotNull
    public static CustomerName randomCustomerName() {
        final String name = new EasyRandom().nextObject(String.class);
        return new CustomerName(name);
    }
}
