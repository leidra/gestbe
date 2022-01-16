package net.leidra.gestbe.customer.shared.application;

public interface QueryHandler<T extends Query<R>, R> extends Handler {
    R handle(T query);
}
