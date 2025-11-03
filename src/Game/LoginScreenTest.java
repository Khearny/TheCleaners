package Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginScreenTest {

    // Test to verify that a new LoginScreen starts with loginSuccessful = false
    @Test
    public void testLoginScreen() {
        LoginScreen login = new LoginScreen();
        assertFalse(login.isLoginSuccessful());
    }

    // Test to confirm the loginSuccessful flag remains false before any login attempt
    @Test
    public void testLoginSuccessFlag() {
        LoginScreen login = new LoginScreen();
        assertFalse(login.isLoginSuccessful());
    }
}
