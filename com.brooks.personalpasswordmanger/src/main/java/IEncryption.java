/**
 * Created by SlickJam on 4/26/2016.
 */

public interface IEncryption {

    String encrypt(AccountInformation accountInfo);

    String getLastError();
}
