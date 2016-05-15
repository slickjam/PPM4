import EncryptionRules.IEncryptionRule;

import java.util.List;

/**
 * Created by SlickJam on 5/1/2016.
 */
public class AccountInformation implements IAccountInformation {
    private String accountName;
    private String password;
    private List<IEncryptionRule> encryptionRules;

    public AccountInformation(){
        // Blank
    }

    public AccountInformation(String accountName, String plainTextPassword, List<IEncryptionRule> encryptionRules){
        add(accountName, plainTextPassword, encryptionRules);
    }

    public void add(String accountName, String plainTextPassword, List<IEncryptionRule> encryptionRules) {

        this.accountName = accountName;
        this.password = plainTextPassword;
        this.encryptionRules = encryptionRules;
    }

    public void modify(String newAccountName) {
        this.accountName = newAccountName;
    }

    public void modify(String newAccountName, String newPlainTextPassword) {

    }

    public void modify(String newAccountName, String newPlainTextPassword, List<IEncryptionRule> encryptionRules) {

    }


    public String getPassword() {
        return password;
    }

    public String getAccountName() {
        return accountName;
    }

    public List<IEncryptionRule> getEncryptionRules() {
        return encryptionRules;
    }
}
