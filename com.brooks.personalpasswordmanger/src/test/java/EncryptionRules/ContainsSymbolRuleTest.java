package EncryptionRules;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SlickJam on 5/15/2016.
 */
public class ContainsSymbolRuleTest {

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