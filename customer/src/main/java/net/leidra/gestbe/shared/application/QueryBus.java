package net.leidra.gestbe.shared.application;

public interface QueryBus {
    <R, T extends Query<R>> R dispatch(T query);
}
