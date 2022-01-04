package net.leidra.gestbe.customer.customer.infrastructure.launcher;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.infrastructure.controller.cli.CliGetCustomersController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class CliGetLauncher implements CommandLineRunner {
    private final CliGetCustomersController controller;

    @Override
    public void run(String... args) {
        System.out.println(controller.searchAll());
    }
}