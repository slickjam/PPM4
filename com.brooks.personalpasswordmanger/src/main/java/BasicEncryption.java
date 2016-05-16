/**
 * Created by SlickJam on 5/14/2016.
 */
public class BasicEncryption implements IEncryption {

    private byte[] encryptionKey;

    BasicEncryption(byte[] encryptionKey){
        this.encryptionKey = encryptionKey;
    }

    public String encrypt(AccountInformation accountInfo) {

        byte[] password = accountInfo.getPassword().getBytes();
        byte[] encryptedPasswordByteArray = bitwiseOrBytes(password, encryptionKey, password.length);
        String encryptedPasswordString = new String(encryptedPasswordByteArray);

        return encryptedPasswordString;
    }

    public String getLastError() {
        return null;
    }

    private byte[] bitwiseOrBytes(byte[] password, byte[] key, int length)
    {
        final int FirstPrintableASCIIChar = 32;
        final int LastPrintableASCIIChar = 127;

        byte[] result = new byte[length];
        if((password.length >= length) && (encryptionKey.length >= length))
        for(int i = 0; i < length; i++)
        {
            int temp = Math.abs((password[i] ^ key[i]));
            if((temp > FirstPrintableASCIIChar) && (temp < LastPrintableASCIIChar))
            {
                result[i] = (byte)temp;
            }
        }

        return result;
    }








}
