package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.Account;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class XMLDeserializerTest {

    static final Account defaultAccount = new Account(2L, 77176, 2, new BigDecimal("11900.00"));
    static final File testFile = new File("accountTestFile.xml");

    @BeforeAll
    void serializeObject() throws Exception {
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(testFile, defaultAccount);
    }

    @Test
    void deserializeObject(){
        Account deserializedAccount = (Account) XMLDeserializer.deserializeObject(Account.class, testFile);
        assertEquals(defaultAccount, deserializedAccount);
    }

    @AfterAll
    void deleteGeneratedFiles(){
        if(testFile.exists())
            testFile.delete();
    }
}