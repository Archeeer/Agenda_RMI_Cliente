package agenda;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {

		DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter horaFormat = DateTimeFormatter.ofPattern("HH:mm");
		String nomeCliente = args[0];
		Menu menu = new Menu();
		boolean loop = true;
		ArrayList<Usuario> convidadosTemp = new ArrayList<>();
		Registry registroNomes;
		InterfaceServ referenciaServidor = null;
		InterfaceCli referenciaCliente = null;
		Scanner scanner = new Scanner(System.in);
		Compromisso convite;

		try {

			System.out.println("[CLIENTE]: Procurando registro de nomes");
			registroNomes = LocateRegistry.getRegistry(); //procurando registro de nomes

			System.out.println("[CLIENTE]: Procurando referencia do Servidor");
			referenciaServidor = (InterfaceServ) registroNomes.lookup("Agenda");

			System.out.println("[CLIENTE]: Criando referencia do Cliente");
			referenciaCliente = new ImplCli(nomeCliente, referenciaServidor); //criando referencia do cliente

			System.out.println("[CLIENTE]: Cadastrando Usuario no Servidor");
			referenciaServidor.cadastroUsuario(nomeCliente, referenciaCliente); //cadastrando usuário no servidor

			System.out.println("[CLIENTE]: Conectado");

		} catch(Exception e){
			e.printStackTrace();
		}

		//        ArrayList<Usuario> e = new ArrayList<>();

		//        referenciaServidor.cadastroCompromisso(nomeCliente, "ABC", LocalDate.parse("19/10/2022", dataFormat), LocalTime.parse("20:00", horaFormat), e);
		//        referenciaServidor.cadastroCompromisso(nomeCliente, "ACB", LocalDate.parse("19/10/2022", dataFormat), LocalTime.parse("20:00", horaFormat), e);
		//        referenciaServidor.cadastroCompromisso(nomeCliente, "BAC", LocalDate.parse("19/10/2022", dataFormat), LocalTime.parse("20:00", horaFormat), e);
		//        referenciaServidor.cadastroCompromisso(nomeCliente, "BCA", LocalDate.parse("19/10/2022", dataFormat), LocalTime.parse("20:00", horaFormat), e);
		//        referenciaServidor.cadastroCompromisso(nomeCliente, "CAB", LocalDate.parse("19/10/2022", dataFormat), LocalTime.parse("20:00", horaFormat), e);

		while (loop) {
			int opcao = menu.menu();

			switch (opcao) {
			case 1:
				convidadosTemp.clear();

				System.out.println("[CLIENTE]: Cadastro de Compromisso");

				System.out.println("[CLIENTE]: Digite o Nome do Compromisso");
				String nomeCompromisso = scanner.nextLine();

				System.out.println("[CLIENTE]: Digite a Data do Compromisso no formato DD/MM/YYYY");
				String linhaData = scanner.nextLine();
				LocalDate data = LocalDate.parse(linhaData, dataFormat);

				System.out.println("[CLIENTE]: Digite a Hora do Compromisso no formato HH:MM");
				String linhaHora = scanner.nextLine();
				LocalTime hora = LocalTime.parse(linhaHora, horaFormat);

				System.out.println("[CLIENTE]: Adicionar Convidados ao Compromisso?\n 1 - SIM\n 2 - NÃO");
				int menuConv = scanner.nextInt();
				scanner.nextLine();
				clearBuffer(scanner);


				if (menuConv == 1) {

					while (menuConv != 0){

						System.out.println("[CLIENTE]: Digite o nome do Convidado ou 0 para sair");

						String nomeTemp = scanner.nextLine();

						Usuario usuarioTemp = referenciaServidor.buscarConvidado(nomeTemp);

						if (usuarioTemp != null) {
							convidadosTemp.add(usuarioTemp);
							System.out.println("[CLIENTE]: Convidado Adicionado");
						}
						else if (nomeTemp.equals("0")){
							break;
						}else
							System.out.println("[CLIENTE]: Convidado não existe");
					}
				}

				//				System.out.println("[CLIENTE]: Chego Aqui?");
				referenciaServidor.cadastroCompromisso(nomeCliente, nomeCompromisso, data, hora, convidadosTemp);
				//				System.out.println("[CLIENTE]: Compromisso Cadastrado?");

				System.out.println("[CLIENTE]: Gostaria de receber um Alerta?");
				menuConv = scanner.nextInt();
				scanner.nextLine();

				if (menuConv == 1) {

					System.out.println("[CLIENTE]: Quanto tempo antes do Compromisso?");
					linhaHora = scanner.nextLine();
					referenciaServidor.criaAlerta(linhaHora, nomeCliente, nomeCompromisso);
					System.out.println("[CLIENTE]: Alerta criado");
					menuConv = 0;
				}

				break;
			case 2:

				System.out.println("[CLIENTE]: Cancelamento de Compromisso");
				System.out.println("[CLIENTE]: Digite o Nome do Compromisso");
				nomeCompromisso = scanner.nextLine();
				referenciaServidor.cancelamentoCompromisso(nomeCompromisso);

				break;
			case 3:

				System.out.println("[CLIENTE]: Cancelamento de Alerta");
				System.out.println("[CLIENTE]: Digite o Nome do Compromisso");
				nomeCompromisso = scanner.nextLine();
				nomeCompromisso += referenciaCliente.toString();
				referenciaServidor.cancelamentoAlerta(nomeCompromisso);

				break;
			case 4:

				System.out.println("[CLIENTE]: Consulta de Compromisso");
				System.out.println("[CLIENTE]: Digite a Data do Compromisso");
				linhaData = scanner.nextLine();
				data = LocalDate.parse(linhaData, dataFormat);
				System.out.println("[CLIENTE]: Chamando Consulta");
				System.out.println (referenciaServidor.consultaCompromisso(data));
				System.out.println("[CLIENTE]: Retorno Consulta");
				break;
			
			case 5:
				
				convite = referenciaCliente.getConvite();
				System.out.println("[CLIENTE]: Quanto tempo antes do Compromisso?");
				linhaHora = scanner.nextLine();
				referenciaServidor.criaAlerta(linhaHora, nomeCliente, convite.Nome);
				System.out.println("[CLIENTE]: Alerta criado");
				menuConv = 0;

			default:
				System.out.println("[CLIENTE]: Sem opção");
			}
		}
	}

	private static void clearBuffer(Scanner scanner) {
		if(scanner.hasNextLine())
		{scanner.nextLine();
		}
	}	
}