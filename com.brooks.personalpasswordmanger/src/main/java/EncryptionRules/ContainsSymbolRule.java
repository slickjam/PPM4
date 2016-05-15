package EncryptionRules;

/**
 * Created by SlickJam on 5/15/2016.
 */
public class ContainsSymbolRule implements IEncryptionRule {

    private boolean required;

    public ContainsSymbolRule()
    {
        required = true;
    }

    public ContainsSymbolRule(boolean required)
    {
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isValid(String password) {
        return doesPasswordContainASymbol(password);
    }

    public String enforce(String password) {
        return null;
    }

    private boolean doesPasswordContainASymbol(String passwordToValidate)
    {
        return passwordToValidate.matches(".*\\W.*");
    }
}
