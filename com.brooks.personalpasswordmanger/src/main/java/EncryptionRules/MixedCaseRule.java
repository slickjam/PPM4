package EncryptionRules;

/**
 * Created by SlickJam on 5/15/2016.
 */
public class MixedCaseRule implements IEncryptionRule
{
    private boolean required;

    public MixedCaseRule()
    {
        required = true;
    }

    public MixedCaseRule(boolean required)
    {
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isValid(String password) {
        return doesPasswordContainMixedCase(password);
    }

    public String enforce(String password) {
        return null;
    }

    private boolean doesPasswordContainMixedCase(String passwordToValidate)
    {
        return (passwordToValidate.matches(".*[A-Z].*") && passwordToValidate.matches(".*[a-z].*"));
    }
}
