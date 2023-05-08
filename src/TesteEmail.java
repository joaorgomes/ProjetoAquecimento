
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TesteEmail {
	public static void main(String[] args) {

		SimpleEmail email = new SimpleEmail();

		try {
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("joaorosivaldopoo@gmail.com","flykofkjvuxrleod");
			email.setSSL(true);
			email.addTo("joaorosivaldopoo@gmail.com"); // pode ser qualquer email
			email.setFrom("joaorosivaldopoo@gmail.com"); // será passado o email que você fará a autenticação
			email.setSubject("Enviando email");
			email.setMsg("Contrato");
			email.send();

		} catch (EmailException e) {

			System.out.println("Falha ao renviar email");

		}

	}
}
