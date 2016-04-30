/**
 * Created by SlickJam on 4/26/2016.
 */
public class BasicPasswordRules implements IPasswordRules {

    // Fields
    private int requiredPasswordLength = 32;
    private boolean numberRequired = true;
    private boolean mixedCaseRequired = true;
    private boolean symbolRequired = true;

    // private data
    String passwordToValidate = "";


    public boolean validatePassword(String encryptedPassword) {

        boolean result;
        passwordToValidate = encryptedPassword;

        result = doesPasswordMeetTheLengthRequired();
        result = result & doesPasswordContainANumber();

        return result;
    }

    public String enforcePasswordRules(String encryptedPassword) {
        return null;
    }


    private boolean doesPasswordMeetTheLengthRequired()
    {
        boolean result = true;
        if(0 != requiredPasswordLength) {
            result = passwordToValidate.length() == requiredPasswordLength;
        }
        return result;
    }

    private boolean doesPasswordContainANumber()
    {
        boolean result = true;
        if(isNumberRequired()) {
            result = passwordToValidate.matches(".*\\d+.*");
        }
        return result;
    }

    // Getters and Setters

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

    public int getRequiredPasswordLength() {
        return requiredPasswordLength;
    }

    public void setRequiredPasswordLength(int requiredPasswordLength) {
        this.requiredPasswordLength = requiredPasswordLength;
    }
}
