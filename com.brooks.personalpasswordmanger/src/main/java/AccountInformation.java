/**
 * Created by SlickJam on 5/1/2016.
 */
public class AccountInformation implements IAccountInformation {
    private String accountName;
    private String password;
    private IPasswordRules passwordRules;

    public AccountInformation(){
        // Blank
    }

    public AccountInformation(String accountName, String plainTextPassword, IPasswordRules passwordRules){
        add(accountName, plainTextPassword, passwordRules);
    }

    public void add(String accountName, String plainTextPassword, IPasswordRules passwordRules) {

        this.accountName = accountName;
        this.password = plainTextPassword;
        this.passwordRules = passwordRules;
    }

    public void modify(String newAccountName) {
        this.accountName = newAccountName;
    }

    public void modify(String newAccountName, String newPlainTextPassword) {

    }

    public void modify(String newAccountName, String newPlainTextPassword, IPasswordRules newPasswordRules) {

    }


    public String getPassword() {
        return password;
    }

    public String getAccountName() {
        return accountName;
    }

    public IPasswordRules getPasswordRules() {
        return passwordRules;
    }
}
