package net.leidra.gestbe.testcontainer;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@DataJdbcTest
@ActiveProfiles({"test"})
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = PostgreSQLITContainer.PostgreSQLITContainerInitializer.class)
public abstract class PostgreSQLITContainer {
    private static final String IMAGE_VERSION = "postgres";

    private static final PostgreSQLContainer container = new PostgreSQLContainer(IMAGE_VERSION);

    static class PostgreSQLITContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(final ConfigurableApplicationContext applicationContext) {
            container.start();

            TestPropertyValues.of("spring.datasource.url=" + container.getJdbcUrl(),
                "spring.datasource.username=" + container.getUsername(),
                "spring.datasource.password=" + container.getPassword()
            ).applyTo(applicationContext.getEnvironment());
        }
    }
}
