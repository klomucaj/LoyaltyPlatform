import it.unicam.cs.ids.loyaltyPlatform.LoyaltyPlatformApplication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoyaltyPlatformApplicationTest {

    @Test
    public void testCheckPassword_ValidPassword() {
        String validPassword = "Password1!";
        boolean result = LoyaltyPlatformApplication.checkPassword(validPassword);

        assertTrue(result, "Valid password should return true");
    }

    @Test
    public void testCheckPassword_InvalidPassword() {
        String invalidPassword = "password"; // No capital letters, no digits, no special characters
        boolean result = LoyaltyPlatformApplication.checkPassword(invalidPassword);
        assertFalse(result, "Invalid password should return false");
    }

    @Test
    public void testCheckPassword_TooShort() {
        String shortPassword = "Short1!"; // Length less than 8 characters
        boolean result = LoyaltyPlatformApplication.checkPassword(shortPassword);
        assertFalse(result, "Password length less than 8 characters should return false");
    }

    @Test
    public void testCheckPassword_NoSpecialCharacter() {
        String passwordWithoutSpecialChar = "Password1"; // No special characters
        boolean result = LoyaltyPlatformApplication.checkPassword(passwordWithoutSpecialChar);
        assertFalse(result, "Password without special character should return false");
    }

    @Test
    public void testCheckPassword_EmptyPassword() {
        String emptyPassword = "";
        boolean result = LoyaltyPlatformApplication.checkPassword(emptyPassword);
        assertFalse(result, "Empty password should return false");
    }

    @Test
    public void testCheckPassword_WhitespacePassword() {
        String whitespacePassword = "    "; // Contains only whitespace characters
        boolean result = LoyaltyPlatformApplication.checkPassword(whitespacePassword);
        assertFalse(result, "Whitespace password should return false");
    }


}
