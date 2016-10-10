import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by khanhdo on 10/8/16.
 */
public class StreamIO {
    public static void writeToFile(String fileName,String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileName));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        String ret = "";
        try {
            InputStream inputStream = new FileInputStream(fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String readFromHtml(String fileName) {

        String ret = "";
        try {
            URL url = new URL(fileName);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((receiveString = in.readLine()) != null) {
                stringBuilder.append(receiveString);
            }
            in.close();
            ret = stringBuilder.toString();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
