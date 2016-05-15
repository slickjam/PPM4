package EncryptionRules;

/**
 * Created by SlickJam on 5/15/2016.
 */
public class MinimumLengthRule implements IEncryptionRule {

    private int requiredPasswordLength;
    private boolean required;

    public MinimumLengthRule()
    {
        requiredPasswordLength = 32;
        required = true;
    }

    public MinimumLengthRule(int length, boolean required)
    {
        requiredPasswordLength = length;
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isValid(String password) {
        return doesPasswordMeetTheLengthRequired(password);
    }

    public String enforce(String password) {
        return null;
    }

    public int getRequiredPasswordLength() {
        return requiredPasswordLength;
    }

    public void setRequiredPasswordLength(int requiredPasswordLength) {
        this.requiredPasswordLength = requiredPasswordLength;
    }

    private boolean doesPasswordMeetTheLengthRequired(String passwordToValidate)
    {
        return (passwordToValidate.length() == requiredPasswordLength);
    }
}
