
public class Cliente {
	private String nome;
	private String CPF;
	private Sexo sexo;
	private String email;
		
	public String toString() {
		return this.nome;
	}
	public Cliente() {};

	public Cliente(String nome, String cPF, Sexo sexo, String email) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.sexo = sexo;
		this.email = email;
	}	
	public boolean equals(Cliente cliente) {
		if(getEmail().equals(cliente.getEmail())){
			return true;
		}
		return false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}

}
