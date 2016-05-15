import EncryptionRules.IEncryptionRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by SlickJam on 5/14/2016.
 */
public class EncryptorTest {

    private Encryptor encryptor;

    @Before
    public void setUp() throws Exception {
        byte[] key =  {0,2,3,4};
        encryptor  = new Encryptor(key);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void encryptWithRequirePasswordLengthOf32() throws Exception {

        int expectedOutputLength = 32;
        List<IEncryptionRule> mockRules = mock(List.class);
        mockRules.add(mock(IEncryptionRule.class));
        AccountInformation ai = new AccountInformation("Amazon", "test1", mockRules);

        String result = encryptor.encrypt(ai);

        assertEquals(expectedOutputLength, result.length());

    }

}