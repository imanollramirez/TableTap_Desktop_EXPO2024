package Modelo;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
Esta es la clase donde se escribe la info con la que se envían los correos de recu
para los usuarios.

Aparte se agregan las librerias que son necesarias, las cuales son:
- Action- 1.1.1.jar
- javax.mail.jar

que están en la carpeta de Librerías.
*/

public class EnviarCorreo {
    
    public static void enviarCorreo(String recipient, String subject, int codigo) {
        
        //1- Propiedades del servidor de correo
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587");

        
        
        //2- Credenciales de la cuenta de correo
        final String myAccountEmail = "tabletapbusiness2024@gmail.com";
        final String password = "rxzk nxhv viqd hvzx";

        // Crear sesión
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //3- Enviar el correo
        try {
            // Crear mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);            
            
            String htmlContent = "<!DOCTYPE html>\n" +
"<html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n" +
"\n" +
"<head>\n" +
"	<title></title>\n" +
"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
"<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
"<link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap\" rel=\"stylesheet\">\n" +
"	<style>\n" +
"		* {\n" +
"			box-sizing: border-box;\n" +
"		}\n" +
"\n" +
"		body {\n" +
"			margin: 0;\n" +
"			padding: 0;\n" +
"		}\n" +
"\n" +
"		a[x-apple-data-detectors] {\n" +
"			color: inherit !important;\n" +
"			text-decoration: inherit !important;\n" +
"		}\n" +
"\n" +
"		#MessageViewBody a {\n" +
"			color: inherit;\n" +
"			text-decoration: none;\n" +
"		}\n" +
"\n" +
"		p {\n" +
"			line-height: inherit\n" +
"		}\n" +
"\n" +
"		.desktop_hide,\n" +
"		.desktop_hide table {\n" +
"			mso-hide: all;\n" +
"			display: none;\n" +
"			max-height: 0px;\n" +
"			overflow: hidden;\n" +
"		}\n" +
"\n" +
"		.image_block img+div {\n" +
"			display: none;\n" +
"		}\n" +
"\n" +
"		@media (max-width:660px) {\n" +
"			.desktop_hide table.icons-inner {\n" +
"				display: inline-block !important;\n" +
"			}\n" +
"\n" +
"			.icons-inner {\n" +
"				text-align: center;\n" +
"			}\n" +
"\n" +
"			.icons-inner td {\n" +
"				margin: 0 auto;\n" +
"			}\n" +
"\n" +
"			.image_block div.fullWidth {\n" +
"				max-width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.mobile_hide {\n" +
"				display: none;\n" +
"			}\n" +
"\n" +
"			.row-content {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.stack .column {\n" +
"				width: 100%;\n" +
"				display: block;\n" +
"			}\n" +
"\n" +
"			.mobile_hide {\n" +
"				min-height: 0;\n" +
"				max-height: 0;\n" +
"				max-width: 0;\n" +
"				overflow: hidden;\n" +
"				font-size: 0px;\n" +
"			}\n" +
"\n" +
"			.desktop_hide,\n" +
"			.desktop_hide table {\n" +
"				display: table !important;\n" +
"				max-height: none !important;\n" +
"			}\n" +
"		}\n" +
"\n" +
"\n" +
"	</style>\n" +
"</head>\n" +
"\n" +
"<body class=\"body\" style=\"background-color: #ffffff; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
"	<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff;\">\n" +
"		<tbody>\n" +
"			<tr>\n" +
"				<td>\n" +
"					<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px; margin: 0 auto;\" width=\"640\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<div class=\"spacer_block block-1\" style=\"height:30px;line-height:30px;font-size:1px;\">&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px; margin: 0 auto;\" width=\"640\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"empty_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td class=\"pad\">\n" +
"																<div></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"												<td class=\"column column-2\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<div class=\"spacer_block block-1\" style=\"height:15px;line-height:15px;font-size:1px;\">&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/1526/ED_BG_shadow.png'); background-position: top center; background-repeat: no-repeat;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px; margin: 0 auto;\" width=\"640\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<div class=\"spacer_block block-1\" style=\"height:70px;line-height:70px;font-size:1px;\">&#8202;</div>\n" +
"													<table class=\"image_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td class=\"pad\" style=\"padding-left:15px;padding-right:15px;width:100%;\">\n" +
"																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\">\n" +
"																	<div class=\"fullWidth\" style=\"max-width: 480px;\"><img src=\"https://firebasestorage.googleapis.com/v0/b/tabletap-expo2024.appspot.com/o/white_logo.png?alt=media&token=4777e918-2b4d-40c9-b0c5-1be90a4763a8\" style=\"display: block; height: auto; border: 0;\" width=\"250\" title=\"Happy Emoji Day Sale Banner\"></div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"paragraph_block block-3\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td class=\"pad\" style=\"padding-bottom:10px;padding-left:40px;padding-right:40px;padding-top:10px;\">\n" +
"																<div style=\"color:#ffffff;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;font-size:26px;line-height:120%;text-align:center;mso-line-height-alt:31.2px;\">\n" +
"																	<p style=\"margin: 0; word-break: break-word;\"><strong style=\"font-family: Poppins\">Saludos, adjuntamos por este medio tu código de recuperación:</strong></p>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<div class=\"spacer_block block-6\" style=\"height:10px;line-height:10px;font-size:1px;\">&#8202;</div>\n" +
"													<table class=\"button_block block-7\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td class=\"pad\">\n" +
"																<div class=\"alignment\" align=\"center\">\n" +
"                                                                <a disable style=\"background-color:#ff1515;border-bottom:0px solid transparent;border-left:0px solid transparent;border-radius:4px;border-right:0px solid transparent;border-top:0px solid transparent;color:#ffffff;display:inline-block;font-family:'Poppins', Helvetica, Arial, sans-serif;font-size:20px;font-weight:undefined;mso-border-alt:none;padding-bottom:5px;padding-top:5px;text-align:center;text-decoration:none;width:auto;word-break:keep-all;\"><span style=\"word-break: break-word; padding-left: 20px; padding-right: 20px; font-size: 20px; display: inline-block; letter-spacing: normal;\"><span style=\"word-break: break-word;\"><span style=\"word-break: break-word; line-height: 40px;\" data-mce-style><strong>" + codigo +"</strong></span></span></span></a></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<div class=\"spacer_block block-8\" style=\"height:20px;line-height:20px;font-size:1px;\">&#8202;</div>\n" +
"													<table class=\"image_block block-9\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td class=\"pad\" style=\"padding-left:10px;width:100%;padding-right:0px;\">\n" +
"																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\">\n" +
"																	<div class=\"fullWidth\" style=\"max-width: 576px;\"><img src=\"https://firebasestorage.googleapis.com/v0/b/tabletap-expo2024.appspot.com/o/announcet_tabletap.png?alt=media&token=62e83ee8-dd30-49fc-9928-48103cb7e93b\" style=\"display: block; height: auto; border: 0; width: 100%;\" width=\"576\" alt=\"Emoji Cart Image\" title=\"Emoji Cart Image\" height=\"auto\"></div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<div class=\"spacer_block block-10\" style=\"height:65px;line-height:65px;font-size:1px;\">&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"				</td>\n" +
"			</tr>\n" +
"		</tbody>\n" +
"	</table>\n" +
"</body>\n" +
"\n" +
"</html>";
            
            message.setContent(htmlContent, "text/html");
            
            // Enviar mensaje
            Transport.send(message);
            System.out.println("Correo enviado con éxito");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    } 
}
