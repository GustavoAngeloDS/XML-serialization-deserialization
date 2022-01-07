import models.Account;
import util.XMLDeserializer;
import util.XMLSerializer;

import java.io.File;
import java.math.BigDecimal;

public class ApplicationEntryPoint {
    public static void main(String[] args) {
        final String FILE_NAME = "account.xml";
        File file = new File(FILE_NAME);
        Account account = new Account(1L, 1699, 1, new BigDecimal("10000.00"));

        XMLSerializer.serializeObject(account, file);
        Account accountDeserialized = (Account) XMLDeserializer.deserializeObject(Account.class, file);
        System.out.println(accountDeserialized);
    }
}
