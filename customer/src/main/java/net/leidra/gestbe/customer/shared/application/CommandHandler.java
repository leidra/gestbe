package net.leidra.gestbe.customer.shared.application;

public interface CommandHandler<T extends Command> extends Handler {
    void handle(T command);
}
