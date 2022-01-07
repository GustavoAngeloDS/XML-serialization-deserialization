package util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;

public class XMLDeserializer {
    public static Object deserializeObject(Class<?> javaClass, File file){
        ObjectMapper objectMapper = new XmlMapper();
        Object objectDeserialized = null;
        try{
            String xml = InputStreamToString.convertToString(new FileInputStream(file));
            objectDeserialized = objectMapper.readValue(xml, javaClass);

        }catch(Exception e){
            System.out.println(e);
        }
        return objectDeserialized;
    }
}
