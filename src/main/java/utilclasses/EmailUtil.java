package utilclasses;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {

    public static void sendEmailWithReport(String excelReportPath, String extentReportPath, String toEmail, String fromEmail, String host, String subject, String body) 
    {
    	// one time password for gmail vibn gbln xvil enoe
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, "vibn gbln xvil enoe");
                
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // Create a multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attachment part
            messageBodyPart = new MimeBodyPart();
            DataSource extentsource = new FileDataSource(extentReportPath);
            messageBodyPart.setDataHandler(new DataHandler(extentsource));
            messageBodyPart.setFileName("extent.html");
            multipart.addBodyPart(messageBodyPart);

            // Attachment: Excel report
            messageBodyPart = new MimeBodyPart();
            DataSource excelSource = new FileDataSource(excelReportPath);
            messageBodyPart.setDataHandler(new DataHandler(excelSource));
            messageBodyPart.setFileName("Excel_Report.xlsx"); // Set the file name for Excel report
            multipart.addBodyPart(messageBodyPart);
            
            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
