package net.leidra.gestbe.testcontainer;

import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DataJdbcTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.NONE, replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class PostgreSQLITContainer extends PostgreSQLTestContainer {
}
