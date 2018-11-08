import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author hh
 * @Date 2018/11/7
 */
public class EmailHelper {

    /**
     * 获取配置文件
     */
    private static final ResourceBundle bundle = ResourceBundle.getBundle("mail");
    /**
     * 发件人邮件用户名（发件人）
     */
    private static final String sendFrom = bundle.getString("email.from");
    /**
     * 发件人邮件授权码
     */
    private static final String password = bundle.getString("password");
    /**
     * 指定发送邮件的主机为 smtp.qq.com (QQ 邮件服务器)
     */
    private static final String host = bundle.getString("email.host");
    /**
     * 发件人昵称
     */
    private static final String nickName = bundle.getString("email.nickName");


    /**
     *
     * @param addressList 邮箱地址（多个以逗号隔开）
     * @param emailTitle 邮件标题
     * @param content 邮件内容
     */
    public static void sendEmail(String addressList, String emailTitle, String content)throws  MessagingException,UnsupportedEncodingException {
        // 步骤一 创建与邮件服务器连接会话
        // 配置与服务器连接参数
        Properties props = new Properties();
        // 设置properties 属性
        //服务器的本地主机(我用的是qq邮箱)smtp.qq.com
        props.setProperty("mail.host", host);
        // 连接认证
        props.setProperty("mail.smtp.auth", "true");
        //发邮件前进行身份校验
        Authenticator authenticator = new Authenticator(){
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendFrom,password);
            }
        };
        // 与邮件服务器连接会话
        Session session = Session.getDefaultInstance(props,authenticator);

        session.setDebug(true);
        // 步骤二 编写Message（邮件）
        Message message = new MimeMessage(session);
        //发送人昵称
        String personal = new String(nickName.getBytes("ISO-8859-1"),"utf-8");
        // from字段（发送人邮箱地址）
        message.setFrom(new InternetAddress(sendFrom,personal,"utf-8"));
        // to 字段（收件人邮箱地址）InternetAddress.parse()：解析字符串成InternetAddress addressList：可以逗号隔开，同时给多个人发送
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addressList));
        // subject字段（邮件标题）
        message.setSubject(emailTitle);
        // 邮件正文内容 （可以发送HTML 内容）
        message.setContent(content,"text/html;charset=UTF-8");
        //步骤三 使用Transport发送邮件
        Transport.send(message);
    }
}