import java.time.LocalDateTime;
import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList<Cliente> todossOsClientes = new ArrayList<Cliente>();
	private ArrayList<Evento> todosOsEventos = new ArrayList<Evento>();

	public ArrayList<Cliente> getTodossOsClientes() {
		return todossOsClientes;
	}

	public void setTodossOsClientes(ArrayList<Cliente> TodossOsClientes) {
		this.todossOsClientes = TodossOsClientes;
	}

	public ArrayList<Evento> getTodosOsEventos() {
		return todosOsEventos;
	}

	public void setTodosOsEventos(ArrayList<Evento> todosOsEventos) {
		this.todosOsEventos = todosOsEventos;
	}

	public boolean adicionarCliente(Cliente cliente) {		
		for (Cliente c : todossOsClientes) {
			if (c.equals(cliente)) {
				return false;
			}
		}		
		todossOsClientes.add(cliente);
		return true;
	}
	public Cliente recuperClientePorEmail(String novoEmail) {
		String novoEmail2 = novoEmail;
		for (Cliente cliente : todossOsClientes) {
			if (cliente.getEmail().equals(novoEmail2)) {
				return cliente;
			}
		}
		return null;
	}
	public boolean adicionarEvento(Evento evento) {
		if (evento.jaOcorreu() || todosOsEventos.contains(evento.getId())) {
			return false;
		} 
		todosOsEventos.add(evento);
		return true;
	}
	public Evento recuperarEventopeloId(long idEvento) {
		for (Evento evento : todosOsEventos) {
			if (idEvento == evento.getId()) {
				return evento;
			}
		}
		return null;
	}
	public ArrayList<Evento> recuperarEventosDeUmCliente(String idEmail) {
		ArrayList<Evento> eventosDeCliente = new ArrayList<Evento>();
		for (Evento evento : todosOsEventos) {
			if (evento.getClienteAssociado().getEmail().equals(idEmail)) {
				eventosDeCliente.add(evento);
			}
		}
		return eventosDeCliente;		
	}
}
