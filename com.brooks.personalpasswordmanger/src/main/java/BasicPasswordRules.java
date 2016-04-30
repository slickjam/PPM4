/**
 * Created by SlickJam on 4/26/2016.
 */
public class BasicPasswordRules implements IPasswordRules {

    // Fields
    private int passwordLength = 32;
    private boolean passwordLengthRequired = true;
    private boolean numberRequired = true;
    private boolean mixedCaseRequired = true;
    private boolean symbolRequired = true;

    // private data
    String passwordToValidate = "";


    public boolean validatePassword(String encryptedPassword) {

        boolean result;
        passwordToValidate = encryptedPassword;

        result = doesPasswordMeetTheLengthRequired();

        return result;
    }

    public String enforcePasswordRules(String encryptedPassword) {
        return null;
    }


    private boolean doesPasswordMeetTheLengthRequired()
    {
        return passwordToValidate.length() == passwordLength;
    }

    // Getters and Setters

    public boolean isPasswordLengthRequired() {
        return passwordLengthRequired;
    }

    public void setPasswordLengthRequired(boolean passwordLengthRequired) {
        this.passwordLengthRequired = passwordLengthRequired;
    }

    public boolean isNumberRequired() {
        return numberRequired;
    }

    public void setNumberRequired(boolean numberRequired) {
        this.numberRequired = numberRequired;
    }

    public boolean isMixedCaseRequired() {
        return mixedCaseRequired;
    }

    public void setMixedCaseRequired(boolean mixedCaseRequired) {
        this.mixedCaseRequired = mixedCaseRequired;
    }

    public boolean isSymbolRequired() {
        return symbolRequired;
    }

    public void setSymbolRequired(boolean symbolRequired) {
        this.symbolRequired = symbolRequired;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }
}
