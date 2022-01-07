package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class XMLSerializer {

    public static void serializeObject(Object object, File file){
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try{
            objectMapper.writeValue(file, object);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
