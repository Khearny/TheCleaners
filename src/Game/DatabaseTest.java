package Game;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    // Test if database connection can be established successfully
    @Test
    public void testDatabaseConnection() {
        assertDoesNotThrow(() -> {
            Connection conn = Database.getConnection();
            assertNotNull(conn);
            conn.close(); 
        });
    }
}
