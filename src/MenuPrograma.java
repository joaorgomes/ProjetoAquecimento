import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Month;

public class MenuPrograma {

	public static void main(String[] args) throws Exception {
		Persistencia pc = new Persistencia();
		CentralDeInformacoes ci = new CentralDeInformacoes();
		Scanner leitor = new Scanner(System.in);
		paradaUniversal: while (true) {
			ci = pc.recuperarCentral("Lista de Clientes.xml");

			System.out.println("Escolha uma das opcões:\n" 	
					+ "[1] Novo cliente\n" 
					+ "[2] Listar todos os clientes\n"
					+ "[3] Exibir Informaçoes de um cliente especifico\n" 
					+ "[4] Novo evento\n"
					+ "[5] Listar todos os eventos\n" 
					+ "[6] Lista todos os eventos de um cliente\n"
					+ "[7] Gerar relatorio de programacao do mes\n" 
					+ "[8] Contratar evento\n" 
					+ "[9] Sair");

			int opcao = Integer.parseInt(leitor.nextLine());
			if (opcao == 1) {
				System.out.print("Digite os dados do no cliente\nNome");
				String nome = leitor.nextLine().toUpperCase();
				System.out.print("CPF:");
				String CPF = leitor.nextLine();
				System.out.print("Sexo[MASCULINO-FEMININO]:");
				Sexo sexo = Sexo.valueOf(leitor.nextLine().toUpperCase());
				System.out.print("Email:");
				String email = leitor.nextLine().toLowerCase();

				Cliente cliente1 = new Cliente(nome, CPF, sexo, email);
				if (ci.adicionarCliente(cliente1)) {
					
					System.out.println("Cliente cadstrado com successo");
				} else {
					System.out.println("Erro, ja esxite um cliente com esses ");
				}
				
			} else if (opcao == 2) {
				for (Cliente clientes : ci.getTodossOsClientes()) {
					System.out.println(clientes.getNome());
				}
				
			} else if (opcao == 3) {
				System.out.println("Digite o email do cliente");
				String email = leitor.nextLine();				
				System.out.println(ci.recuperClientePorEmail(email));
				
			} else if (opcao == 4) {

				System.out.println("Digite o nome do evento");
				String nomeEvento = leitor.nextLine();
				System.out.println("Digite a data do evento:[DD/MM/AAAA]");
				String data = leitor.nextLine();
				String[] convertido = data.split("/");

				LocalDateTime date = LocalDateTime
						.parse(convertido[2] + "-" + convertido[1] + "-" + convertido[0] + "T00:00:01.485");

				

				System.out.println("Digite o local do evento ");
				String local = leitor.nextLine().toUpperCase();
				System.out.println("Digite o email do cliente");
				String email = leitor.nextLine().toLowerCase();
				Cliente cliente = ci.recuperClientePorEmail(email);
				Evento evento = new Evento(nomeEvento, date, local, cliente);

				if (ci.adicionarEvento(evento)) {					
					System.out.println("Evento adicionado");
				} else {
					System.out.println("Nao foi possivel adicionar o evento");
				}
				
			} else if (opcao == 5) {
				System.out.println("Segue lista de eventos:");
				System.out.println();
				for (Evento evento : ci.getTodosOsEventos()) {
					System.out.println("- " + evento.getNomeEvento());
				}
				
			} else if (opcao == 6) {
				System.out.println("Digite o email do cliente");
				String email = leitor.nextLine();
				ArrayList<Evento> todosEventos = ci.recuperarEventosDeUmCliente(email);

				for (Evento e : todosEventos) {
					System.out.println(e.getNomeEvento());
				}

			} else if (opcao == 7) {

				System.out.println("Digite o mes que vc deseja exibr o relatorio\n"
						+ "[1] JANEIRO\n"
						+ "[2] FEVEREIRO\n"
						+ "[3] MARÇO\n"
						+ "[4] ABRIL\n"
						+ "[5] MAIO\n"
						+ "[6] JUNHO\n"
						+ "[7] JULHO\n"
						+ "[8] AGOSTO\n" 
						+ "[9] SETEMBRO\n"
						+ "[10] OUTUBRO\n"
						+ "[11] NOMEMBRO\n"
						+ "[12] DEZEMBRO\n");
						
				Month escolhaMes =ConversaoMonth.convertido(leitor.nextLine());		

				GeradorDeRelatorios.obterRelatorioDoMes(escolhaMes, ci);
				
			} else if (opcao == 8) {
				for (Evento eventos : ci.getTodosOsEventos()) {
					if (!eventos.isFoiContratado())
						System.out.println(eventos.getNomeEvento());
				}
				System.out.print("Qual do eventos deseja contratar: ");
				String resposta = leitor.nextLine();
				Evento e = null;
				for (int i = 0; i < ci.getTodosOsEventos().size(); i++) {
					if (ci.getTodosOsEventos().get(i).getNomeEvento().equals(resposta)) {
						ci.getTodosOsEventos().get(i).setFoiContratado(true);
						e = ci.getTodosOsEventos().get(i);
					}
				}
				String msg = "Caro " + e.getClienteAssociado().getNome() + ", segue dados do seu evento contratado:\n"
						+ "Nome:" + e.getNomeEvento() + "\nData: " + e.getData() + "\nLocal: " + e.getLocal();
				Mensageiro.enviarEmailParaCliente(e, msg);
			} else if (opcao == 9) {
				System.out.println("Programa finalizado!");
				break paradaUniversal;
			}
			
			pc.salvarCentral(ci, "Lista de Clientes.xml");
		}

	}

}
