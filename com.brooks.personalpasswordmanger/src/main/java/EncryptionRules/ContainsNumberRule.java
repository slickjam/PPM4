package EncryptionRules;

/**
 * Created by SlickJam on 5/15/2016.
 */
public class ContainsNumberRule implements IEncryptionRule {


    private boolean required;

    public ContainsNumberRule()
    {
        required = true;
    }

    public ContainsNumberRule(boolean required)
    {
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isValid(String password) {
        return doesPasswordContainANumber(password);
    }

    public String enforce(String password) {
        return null;
    }

    private boolean doesPasswordContainANumber(String passwordToValidate)
    {
        return passwordToValidate.matches(".*\\d+.*");
    }
}
