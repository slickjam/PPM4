import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by SlickJam on 5/1/2016.
 */
public class AccountInformationTest {
    AccountInformation accountInfo;

    @Before
    public void setUp() throws Exception {
         accountInfo = new AccountInformation();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void defaultConstructorInitObjectsAsExpected() throws Exception {

        assertEquals(null, accountInfo.getAccountName());
        assertEquals(null, accountInfo.getPassword());
        assertEquals(null, accountInfo.getPasswordRules());
    }

    @Test
    public void addAccountInformationThenGetThatInformation() throws Exception {
        IPasswordRules mockRules = mock(IPasswordRules.class);

        accountInfo.add("JohnDoe","password", mockRules);

        assertEquals("JohnDoe", accountInfo.getAccountName());
        assertEquals("password", accountInfo.getPassword());
        assertEquals(mockRules, accountInfo.getPasswordRules());
    }

    @Test
    public void addAccountInformationWithTheConstructorThenGetThatInformation() throws Exception {
        IPasswordRules mockRules = mock(IPasswordRules.class);

        AccountInformation ai = new AccountInformation("JohnDoe","password", mockRules);

        assertEquals("JohnDoe", ai.getAccountName());
        assertEquals("password", ai.getPassword());
        assertEquals(mockRules, ai.getPasswordRules());
    }

    @Test
    public void modifyExistingAccountInformationAccountName() throws Exception {
        IPasswordRules mockRules = mock(IPasswordRules.class);

        AccountInformation ai = new AccountInformation("JohnDoe","password", mockRules);

        assertEquals("JohnDoe", ai.getAccountName());
        assertEquals("password", ai.getPassword());
        assertEquals(mockRules, ai.getPasswordRules());

        ai.modify("JamesSmith");

        assertEquals("JamesSmith", ai.getAccountName());
        assertEquals("password", ai.getPassword());
        assertEquals(mockRules, ai.getPasswordRules());
    }

}