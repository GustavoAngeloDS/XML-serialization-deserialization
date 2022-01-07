package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.Account;
import org.junit.jupiter.api.*;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class XMLSerializerTest {

    static final Account defaultAccount = new Account(1L, 1288, 6, new BigDecimal("900.00"));
    static final File testFile = new File("accountTestFile.xml");

    @Test
    @Order(1)
    void serializeObject(){
        XMLSerializer.serializeObject(defaultAccount, testFile);
        assertTrue(testFile.exists());
        assertTrue(testFile.length() > 0);
    }

    @Test
    @Order(2)
    void isDeserializedObjectEqualsDefaultAccount() throws Exception{
        ObjectMapper mapper = new XmlMapper();
        Account deserializedAccount = (Account) mapper.readValue(testFile, Account.class);
        assertEquals(deserializedAccount, defaultAccount);
    }

    @AfterAll
    static void deleteGeneratedFiles(){
        if(testFile.exists())
            testFile.delete();
    }
}