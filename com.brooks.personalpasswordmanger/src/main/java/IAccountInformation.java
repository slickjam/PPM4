import EncryptionRules.IEncryptionRule;

import java.util.List;

/**
 * Created by SlickJam on 5/1/2016.
 */
public interface IAccountInformation {
    void add(String accountName, String plainTextPassword, List<IEncryptionRule> encryptionRules);
    void modify(String newAccountName);
    void modify(String newAccountName, String newPlainTextPassword);
    void modify(String newAccountName, String newPlainTextPassword, List<IEncryptionRule> encryptionRules);
}
