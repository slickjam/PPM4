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
        Assert.assertTrue(result);
    }

    @Test
    public void lengthOfPasswordIsNotValid() throws Exception {
        boolean result = baseRules.validatePassword("qwertyuiopasdfghjklzxcvbnmqwert");
        Assert.assertFalse(result);
    }

}