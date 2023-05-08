import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public abstract class Mensageiro {
	public static void enviarEmailParaCliente(Evento eventoContratar, String msg) {
		SimpleEmail email = new SimpleEmail();

		try {
			//email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("joaorosivaldopoo@gmail.com", "flykofkjvuxrleod");
			email.setSSL(true);
			email.addTo(eventoContratar.getClienteAssociado().getEmail()); // pode ser qualquer email
			email.setFrom(eventoContratar.getClienteAssociado().getEmail()); // será passado o email que você fará a autenticação
			email.setSubject("Contrato");
			email.setMsg(msg);
			email.send();

		} catch (EmailException e) {

			System.out.println("Falha ao enviar email");

		}

	}

}
