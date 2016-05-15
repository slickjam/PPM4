package EncryptionRules;

/**
 * Created by SlickJam on 4/26/2016.
 */
public interface IEncryptionRule {

    // True if the rules required
    boolean isRequired();

    // True is the password meets the requirement
    boolean isValid(String password);

    // Returns a string that meets requirement of rule
    String enforce(String password);

}
