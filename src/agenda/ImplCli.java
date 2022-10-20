package agenda;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ImplCli extends UnicastRemoteObject implements InterfaceCli {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String Nome;
	InterfaceServ refServidor;

	//	InterfaceServ referenciaServidor = null;

	public ImplCli(String N, InterfaceServ refServidor) throws RemoteException {
		super();
		this.Nome = N;
		this.refServidor = refServidor;
	}

	@Override
	public void mostrarAlerta(String infoCompromisso) {
		System.out.println("[CLIENTE]: Alerta recebido");
		System.out.println("[CLIENTE]: " + infoCompromisso);
	}

	@Override
	public void mostrarConvite(Compromisso compromisso) throws RemoteException {

		System.out.println("[CLIENTE]: Convite recebido\n");
		System.out.println(compromisso +" \n");
		System.out.println(compromisso.Convidados + "\n");
		System.out.println("[CLIENTE]: Gostaria de receber um Alerta?");
		Scanner scanner = new Scanner(System.in);
		int menuConv =  scanner.nextInt();
		scanner.nextLine();

		if (menuConv == 1) {

			System.out.println("[CLIENTE]: Quanto tempo antes do Compromisso?");
			String linhaHora = scanner.nextLine();
			refServidor.criaAlerta(linhaHora, Nome, compromisso.Nome);
			System.out.println("[CLIENTE]: Alerta criado");
			menuConv = 0;
		}
	}

}
