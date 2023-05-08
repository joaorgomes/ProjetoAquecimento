import java.time.LocalDateTime;


public class Evento {
	private long id;
	private String nomeEvento;
	private LocalDateTime data;
	private String local;
	private Cliente clienteAssociado;
	private boolean foiContratado;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Cliente getClienteAssociado() {
		return clienteAssociado;
	}

	public void setClienteAssociado(Cliente clienteAssociado) {
		this.clienteAssociado = clienteAssociado;
	}

	public boolean isFoiContratado() {
		return foiContratado;
	}

	public void setFoiContratado(boolean foiContratado) {
		this.foiContratado = foiContratado;
	}
	
	
	
	public Evento(String nomeEvento, LocalDateTime data, String local, Cliente clienteAssociado) {
		this.id = System.currentTimeMillis();
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.clienteAssociado = clienteAssociado;
		this.foiContratado = false;
	}
	public boolean jaOcorreu() {
		LocalDateTime dataAtual=LocalDateTime.now();
		if(dataAtual.isAfter(getData())) {
			return true;
		}else {
			return false;
		}
			
	}
	public String toString() {
		return "<"+clienteAssociado.getNome()+ "> <convida para seu> <"+ getNomeEvento()+">, <"+id+">em<"+	getData()+"> em <"+ getLocal()+">";
		
	}
	public boolean equals(Evento evento) {
		if(getId()==evento.getId()) {
			return true;
		}
		return  false;
	}
	
	
	
	
	
	
	
	
}
