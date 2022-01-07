package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamToString {

    public static String convertToString(InputStream inputStream){
        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        try{
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return sb.toString();
    }
}
