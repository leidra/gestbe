package net.leidra.gestbe.shared.application;

public interface CommandBus {
    <T extends Command> void dispatch(T command);
}
