package EncryptionRules;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SlickJam on 5/15/2016.
 */
public class MinimumLengthRuleTest {


    @Test
    public void passwordLengthIsRequired() throws Exception {
        MinimumLengthRule minimumLengthRule = new MinimumLengthRule();
        assertTrue(minimumLengthRule.isRequired());
    }

    @Test
    public void passwordLengthIsNotRequired() throws Exception {
        MinimumLengthRule minimumLengthRule = new MinimumLengthRule(32, false);
        assertFalse(minimumLengthRule.isRequired());
    }

    @Test
    public void lengthOfPasswordIsValid() throws Exception {
        MinimumLengthRule minimumLengthRule = new MinimumLengthRule(32, true);
        boolean result = minimumLengthRule.isValid("qwertyuiopasdfghjklzxcvbnmqwerty");
        assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsNotValid() throws Exception {
        MinimumLengthRule minimumLengthRule = new MinimumLengthRule(32, true);
        boolean result = minimumLengthRule.isValid("qwertyuiopasdfghjklzxcvbnmqwert");
        assertFalse(result);
    }

    @Test
    public void lengthOfPasswordIsValidAfterLengthIsChanged() throws Exception {

        String testString = "Hi There!";
        MinimumLengthRule minimumLengthRule = new MinimumLengthRule(testString.length(), true);
        boolean result = minimumLengthRule.isValid(testString);
        assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsStillValidAfterLengthIsChanged() throws Exception {
        String testString = "Hi There!";
        MinimumLengthRule minimumLengthRule = new MinimumLengthRule();
        minimumLengthRule.setRequiredPasswordLength(testString.length());
        boolean result = minimumLengthRule.isValid(testString);
        assertTrue(result);
        minimumLengthRule.setRequiredPasswordLength(testString.length());
        result = minimumLengthRule.isValid(testString);
        assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsValidBasedOnNotBeingRequired() throws Exception {
        String testString = "Hi There!";
        MinimumLengthRule minimumLengthRule = new MinimumLengthRule(testString.length() - 1, false);
        boolean result = minimumLengthRule.isValid(testString);
        assertFalse(result);
        result = true;
        if(minimumLengthRule.isRequired()) {
            result = minimumLengthRule.isValid(testString);
        }
        assertTrue(result);
    }

}