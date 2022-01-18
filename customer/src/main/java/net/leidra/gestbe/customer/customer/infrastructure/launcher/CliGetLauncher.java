package net.leidra.gestbe.customer.customer.infrastructure.launcher;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.leidra.gestbe.customer.customer.infrastructure.controller.cli.CustomerGetCliController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@AllArgsConstructor
public final class CliGetLauncher implements CommandLineRunner {
    private final CustomerGetCliController controller;

    @Override
    public void run(String... args) {
       log.info(controller.searchAll());
    }
}