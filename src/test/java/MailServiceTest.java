import org.testng.annotations.Test;
import web.service.Mail;
import web.service.MailWSResponse;
import web.service.impl.MailService;
import web.service.impl.MailServiceImplService;

import javax.xml.bind.JAXBElement;
import java.awt.print.Book;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
public class MailServiceTest {
    private static MailService SERVICE = new MailServiceImplService().getMailServiceImplPort();
   @Test
    public void getAllMailsSuccesTest(){
        MailWSResponse response = SERVICE.getAllMails();
        List<JAXBElement<?>> allMails = response.getContent();
        assertNotNull(allMails);
        assertEquals(allMails.size(),11);
        String expectedStatus = "Get all mails successfully";
//        String actualStatus = response.getStatus().getMessage();
//        assertEquals(actualStatus,expectedStatus);
    }
    @Test
    public void getMailByIdSuccesTest(){
        MailWSResponse response = SERVICE.getMailById(1);
        Mail expected = new Mail(1, "bilokura@gmail.com", "Subject1","content1");
        assertNotNull(response.getContent().get(0));
        String expectedStatus = "Get mail by id successfully";
//        String actualStatus = response.getStatus().getMessage();
//        assertEquals(actualStatus,expectedStatus);
    }
    @Test
    public void getMailByIdFailureTest(){
        MailWSResponse response = SERVICE.getMailById(-1);
        Mail actual = (Mail) response.getContent();
        assertNull(actual);
        String expectedStatus = "There is no such mail";
//        String actualStatus = response.getStatus().getMessage();
//        assertEquals(actualStatus,expectedStatus);
    }
    @Test
    public void getMailByEmailSuccesTest(){
        MailWSResponse response = SERVICE.getMailByEmail("bilokura@gmail.com");
        JAXBElement<?> actual = response.getContent().get(0);
        assertNotNull(actual);
        String expectedStatus = "Get mail by email successfully";
//        String actualStatus = response.getStatus().getMessage();
//        assertEquals(actualStatus,expectedStatus);
    }
    @Test
    public void getMailByEmailFailureTest(){
        MailWSResponse response = SERVICE.getMailByEmail("___________________");
        Mail actual = (Mail) response.getContent();
        assertNull(actual);
        String expectedStatus = "There is no such mail";
//        String actualStatus = response.getStatus().getMessage();
//        assertEquals(actualStatus,expectedStatus);
    }

    @Test
    public void deleteMailSuccesTest(){
        MailWSResponse response = SERVICE.deleteMail(101);
        String expectedStatus = "There is no such mail";
//        String actualStatus = response.getStatus().getMessage();
//        assertEquals(actualStatus,expectedStatus);

    }

    @Test
    public void giveBackBookFailureTest(){
        Mail giveBackBook = new Mail(1, "Give Mail Book Author", "Fantasy","content2");
        MailWSResponse response = SERVICE.addMail(giveBackBook);

        String expectedStatus = "This mail exists already.";
//        String actualStatus = response.getStatus().getMessage();
//        assertEquals(actualStatus,expectedStatus);
    }
}




