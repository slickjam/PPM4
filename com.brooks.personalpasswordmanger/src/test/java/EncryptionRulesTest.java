import EncryptionRules.ContainsNumberRule;
import EncryptionRules.ContainsSymbolRule;
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

    @Test
    public void passwordContainsNumberIsRequired() throws Exception {
        ContainsNumberRule containsNumberRule = new ContainsNumberRule();
        assertTrue(containsNumberRule.isRequired());
    }

    @Test
    public void passwordContainsNumberIsNotRequired() throws Exception {
        ContainsNumberRule containsNumberRule = new ContainsNumberRule(false);
        assertFalse(containsNumberRule.isRequired());
    }

    @Test
    public void passwordContainsAtLeastOneNumber() throws Exception {
        ContainsNumberRule containsNumberRule = new ContainsNumberRule(true);
        String testString = "Hi Number 42!";
        boolean result = containsNumberRule.isValid(testString);
        assertTrue(result);
    }

    @Test
    public void passwordDoesNotContainsAtLeastOneNumber() throws Exception {
        ContainsNumberRule containsNumberRule = new ContainsNumberRule();
        String testString = "Hi Number!";
        boolean result = containsNumberRule.isValid(testString);
        assertFalse(result);
    }

    @Test
    public void passwordMixedCaseIsRequired() throws Exception {
        MixedCaseRule mixedCaseRule = new MixedCaseRule();
        assertTrue(mixedCaseRule.isRequired());
    }

    @Test
    public void passwordMixedCaseIsNotRequired() throws Exception {
        MixedCaseRule mixedCaseRule = new MixedCaseRule(false);
        assertFalse(mixedCaseRule.isRequired());
    }

    @Test
    public void passwordIsAllUppercase() throws Exception {
        MixedCaseRule mixedCaseRule = new MixedCaseRule(true);
        String testString = "HELLO";
        boolean result = mixedCaseRule.isValid(testString);
        assertFalse(result);
    }

    @Test
    public void passwordIsMixedCase() throws Exception {
        MixedCaseRule mixedCaseRule = new MixedCaseRule();
        String testString = "Hello";
        boolean result = mixedCaseRule.isValid(testString);
        assertTrue(result);
    }

    @Test
    public void passwordIsAllLowercase() throws Exception {
        MixedCaseRule mixedCaseRule = new MixedCaseRule();
        String testString = "hello";
        boolean result = mixedCaseRule.isValid(testString);
        assertFalse(result);
    }

    @Test
    public void passwordSymbolIsRequired() throws Exception {
        ContainsSymbolRule containsSymbolRule = new ContainsSymbolRule();
        assertTrue(containsSymbolRule.isRequired());
    }

    @Test
    public void passwordSymbolIsNotRequired() throws Exception {
        ContainsSymbolRule containsSymbolRule = new ContainsSymbolRule(false);
        assertFalse(containsSymbolRule.isRequired());
    }

    @Test
    public void passwordRequiresASymbol() throws Exception {
        ContainsSymbolRule containsSymbolRule = new ContainsSymbolRule();
        String testString = "hello!";
        boolean result = containsSymbolRule.isValid(testString);
        assertTrue(result);
    }

    @Test
    public void passwordRequiresASymbolAndDoesNotContainOne() throws Exception {
        ContainsSymbolRule containsSymbolRule = new ContainsSymbolRule(true);
        String testString = "hello";
        boolean result = containsSymbolRule.isValid(testString);
        assertFalse(result);
    }

   @Test
    public void passwordRequiresASymbolCheckMultipleSymbols() throws Exception {
       ContainsSymbolRule containsSymbolRule = new ContainsSymbolRule(true);

        String testString = "hel@lo";
        boolean result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell#";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell$";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell%";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell^";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell&";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell*";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell(";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell-";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell+";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell`";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell~";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);

        testString = "hell?";
        result = containsSymbolRule.isValid(testString);
        assertTrue(result);
    }
}