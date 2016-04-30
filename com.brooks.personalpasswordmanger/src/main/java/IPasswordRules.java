/**
 * Created by SlickJam on 4/26/2016.
 */
public interface IPasswordRules {

    boolean validatePassword(String encryptedPassword);
    String enforcePasswordRules(String encryptedPassword);

}
