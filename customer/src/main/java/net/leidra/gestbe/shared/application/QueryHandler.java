package net.leidra.gestbe.shared.application;

public interface QueryHandler<T extends Query<R>, R> extends Handler {
    R handle(T query);
}
