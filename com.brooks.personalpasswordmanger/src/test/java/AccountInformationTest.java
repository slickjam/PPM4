import EncryptionRules.IEncryptionRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
        assertEquals(null, accountInfo.getEncryptionRules());
    }

    @Test
    public void addAccountInformationThenGetThatInformation() throws Exception {
        List<IEncryptionRule> mockRules = mock(List.class);
        mockRules.add(mock(IEncryptionRule.class));

        accountInfo.add("JohnDoe","password", mockRules);

        assertEquals("JohnDoe", accountInfo.getAccountName());
        assertEquals("password", accountInfo.getPassword());
        assertEquals(mockRules, accountInfo.getEncryptionRules());
    }

    @Test
    public void addAccountInformationWithTheConstructorThenGetThatInformation() throws Exception {
        List<IEncryptionRule> mockRules = mock(List.class);
        mockRules.add(mock(IEncryptionRule.class));

        AccountInformation ai = new AccountInformation("JohnDoe","password", mockRules);

        assertEquals("JohnDoe", ai.getAccountName());
        assertEquals("password", ai.getPassword());
        assertEquals(mockRules, ai.getEncryptionRules());
    }

    @Test
    public void modifyExistingAccountInformationAccountName() throws Exception {
        List<IEncryptionRule> mockRules = mock(List.class);
        mockRules.add(mock(IEncryptionRule.class));

        AccountInformation ai = new AccountInformation("JohnDoe","password", mockRules);

        assertEquals("JohnDoe", ai.getAccountName());
        assertEquals("password", ai.getPassword());
        assertEquals(mockRules, ai.getEncryptionRules());

        ai.modify("JamesSmith");

        assertEquals("JamesSmith", ai.getAccountName());
        assertEquals("password", ai.getPassword());
        assertEquals(mockRules, ai.getEncryptionRules());
    }

}