import org.junit.After;
import org.junit.Assert;
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
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void lengthOfPasswordIsValid() throws Exception {
        boolean result = baseRules.validatePassword("qwertyuiopasdfghjklzxcvbnmqwerty");
        assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsNotValid() throws Exception {
        boolean result = baseRules.validatePassword("qwertyuiopasdfghjklzxcvbnmqwert");
        assertFalse(result);
    }

    @Test
    public void lengthOfPasswordIsValidAfterLengthIsChanged() throws Exception {

        String testString = "Hi There!";
        baseRules.setPasswordLength(testString.length());
        boolean result = baseRules.validatePassword(testString);
        assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsNotValidAfterLengthIsChanged() throws Exception {
        String testString = "Hi There!";
        baseRules.setPasswordLength(testString.length());
        boolean result = baseRules.validatePassword(testString);
        assertTrue(result);
        baseRules.setPasswordLength(testString.length() - 1);
        result = baseRules.validatePassword(testString);
        assertFalse(result);
    }
}