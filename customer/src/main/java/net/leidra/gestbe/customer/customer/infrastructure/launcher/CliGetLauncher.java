package net.leidra.gestbe.customer.customer.infrastructure.launcher;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.customer.customer.infrastructure.controller.cli.CliGetCustomerController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class CliGetLauncher implements CommandLineRunner {
    private final CliGetCustomerController controller;

    @Override
    public void run(String... args) {
        System.out.println(controller.findAll());
    }
}