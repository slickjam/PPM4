import EncryptionRules.MinimumLengthRule;
import EncryptionRules.MixedCaseRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SlickJam on 4/30/2016.
 */
public class EncryptionRulesTest {

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

   /* @Test
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
    }*/
}