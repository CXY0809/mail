
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public class AppMain {

    public static void main(String[] args) {
        String content = "<h1>This is actual message</h1>";
        try {
            //发送的邮箱地址
            EmailHelper.sendEmail("", "title", content);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
