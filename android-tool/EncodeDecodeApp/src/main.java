import java.io.File;

/**
 * Created by khanhdo on 10/8/16.
 */

public class main {
    public static void main(String[] args) throws Exception{

        // Read data from data.json file
        String originalString = StreamIO.readFromFile("data/data.json");

        System.out.println("originalString: " + originalString);

        // Encrypt data
        String encryptedString = AES.encrypt(originalString) ;
        StreamIO.writeToFile("data/document.encrypted",encryptedString);

        System.out.println("encryptedString: " + encryptedString);

        // Decrypt data
        String encryptedData = StreamIO.readFromFile("data/document.encrypted");
        String decryptedString = AES.decrypt(encryptedData) ;
        System.out.println("decryptedString: " + decryptedString);

        // Upload to git
    // https://raw.githubusercontent.com/khanhdodang/android-apps/master/YW5kcm9pZC1wbXAtZmxhc2hjYXJkLWZyZWU%3D.data
    }
}
