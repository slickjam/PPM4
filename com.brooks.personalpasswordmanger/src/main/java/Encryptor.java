/**
 * Created by SlickJam on 5/14/2016.
 */
public class Encryptor implements IEncryptor {

    private byte[] encryptionKey;

    Encryptor(byte[] encryptionKey){
        this.encryptionKey = encryptionKey;
    }

    public String encrypt(AccountInformation accountInfo) {

        return "";
    }


   /* private boolean validatePassword(String encryptedPassword) {


        boolean result = doesPasswordMeetTheLengthRequired();
        result = result & doesPasswordContainANumber();
        result = result & doesPasswordContainMixedCase();
        result = result & doesPasswordContainASymbol();

        return result;
    }*/








}
