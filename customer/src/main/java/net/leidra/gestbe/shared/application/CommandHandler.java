package net.leidra.gestbe.shared.application;

public interface CommandHandler<T extends Command> extends Handler {
    void handle(T command);
}
