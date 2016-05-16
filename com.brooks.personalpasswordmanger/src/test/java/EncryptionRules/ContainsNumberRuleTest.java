package EncryptionRules;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SlickJam on 5/15/2016.
 */
public class ContainsNumberRuleTest {

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
}