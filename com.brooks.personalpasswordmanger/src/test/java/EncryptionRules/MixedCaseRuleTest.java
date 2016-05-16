package EncryptionRules;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SlickJam on 5/15/2016.
 */
public class MixedCaseRuleTest {

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
}