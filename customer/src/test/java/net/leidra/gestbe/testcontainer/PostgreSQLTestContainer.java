package net.leidra.gestbe.testcontainer;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.annotation.PreDestroy;

@ActiveProfiles("test")
public abstract class PostgreSQLTestContainer {
    private static final String IMAGE_VERSION = "postgres";

    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>(IMAGE_VERSION);

    @DynamicPropertySource
    public static void initialize(final DynamicPropertyRegistry registry) {
        container.start();

        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @PreDestroy
    void destroy() {
        container.stop();
    }
}
