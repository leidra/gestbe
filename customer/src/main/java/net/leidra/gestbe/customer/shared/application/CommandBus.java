package net.leidra.gestbe.customer.shared.application;

public interface CommandBus {
    <T extends Command> void dispatch(T command);
}
