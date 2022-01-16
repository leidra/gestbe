package net.leidra.gestbe.customer.shared.application;

public interface QueryBus {
    <R, T extends Query<R>> R dispatch(T query);
}
