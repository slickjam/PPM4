import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SlickJam on 4/30/2016.
 */
public class BasicPasswordRulesTest {

    BasicPasswordRules baseRules;
    @Before
    public void setUp() throws Exception {
        baseRules = new BasicPasswordRules();
        baseRules.setRequiredPasswordLength(0);
        baseRules.setNumberRequired(false);
        baseRules.setMixedCaseRequired(false);
        baseRules.setSymbolRequired(false);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void lengthOfPasswordIsValid() throws Exception {
        baseRules.setRequiredPasswordLength(32);
        boolean result = baseRules.validatePassword("qwertyuiopasdfghjklzxcvbnmqwerty");
        assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsNotValid() throws Exception {
        baseRules.setRequiredPasswordLength(32);
        boolean result = baseRules.validatePassword("qwertyuiopasdfghjklzxcvbnmqwert");
        assertFalse(result);
    }

    @Test
    public void lengthOfPasswordIsValidAfterLengthIsChanged() throws Exception {

        String testString = "Hi There!";
        baseRules.setRequiredPasswordLength(testString.length());
        boolean result = baseRules.validatePassword(testString);
        assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsStillValidAfterLengthIsChanged() throws Exception {
        String testString = "Hi There!";
        baseRules.setRequiredPasswordLength(testString.length());
        boolean result = baseRules.validatePassword(testString);
        assertTrue(result);
        baseRules.setRequiredPasswordLength(testString.length());
        result = baseRules.validatePassword(testString);
        assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsStillNotValidUntilAfterLengthIsChangedToZero() throws Exception {
        String testString = "Hi There!";
        baseRules.setRequiredPasswordLength(testString.length() - 1);
        boolean result = baseRules.validatePassword(testString);
        assertFalse(result);
        baseRules.setRequiredPasswordLength(0);
        result = baseRules.validatePassword(testString);
        assertTrue(result);
    }

    @Test
    public void passwordContainsAtLeastOneNumber() throws Exception {
        baseRules.setNumberRequired(true);
        String testString = "Hi Number 42!";
        boolean result = baseRules.validatePassword(testString);
        assertTrue(result);
    }

    @Test
    public void passwordDoesNotContainsAtLeastOneNumber() throws Exception {
        baseRules.setNumberRequired(true);
        String testString = "Hi Number!";
        boolean result = baseRules.validatePassword(testString);
        assertFalse(result);
    }

    @Test
    public void passwordIsAllUppercase() throws Exception {
        baseRules.setMixedCaseRequired(true);
        String testString = "HELLO";
        boolean result = baseRules.validatePassword(testString);
        assertFalse(result);
    }

    @Test
    public void passwordIsMixedCase() throws Exception {
        baseRules.setMixedCaseRequired(true);
        String testString = "Hello";
        boolean result = baseRules.validatePassword(testString);
        assertTrue(result);
    }

    @Test
    public void passwordIsAllLowercase() throws Exception {
        baseRules.setMixedCaseRequired(true);
        String testString = "hello";
        boolean result = baseRules.validatePassword(testString);
        assertFalse(result);
    }

    @Test
    public void passwordRequiresASymbol() throws Exception {
        baseRules.setSymbolRequired(true);
        String testString = "hello!";
        boolean result = baseRules.validatePassword(testString);
        assertTrue(result);
    }
    @Test
    public void passwordRequiresASymbolAndDoesNotContainOne() throws Exception {
        baseRules.setSymbolRequired(true);
        String testString = "hello";
        boolean result = baseRules.validatePassword(testString);
        assertFalse(result);
    }

    @Test
    public void passwordRequiresASymbolCheckMultipleSymbols() throws Exception {
        baseRules.setSymbolRequired(true);

        String testString = "hel@lo";
        boolean result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell#";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell$";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell%";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell^";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell&";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell*";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell(";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell-";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell+";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell`";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell~";
        result = baseRules.validatePassword(testString);
        assertTrue(result);

        testString = "hell?";
        result = baseRules.validatePassword(testString);
        assertTrue(result);
    }
}