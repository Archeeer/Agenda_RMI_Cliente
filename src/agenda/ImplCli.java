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
	Compromisso convite;

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

		this.convite = compromisso;
		System.out.println("[CLIENTE]: Convite recebido\n");
		System.out.println(convite +" \n");
		System.out.println(convite.Convidados + "\n");
		System.out.println("[CLIENTE]: Gostaria de receber um Alerta? 5 para sim");
	}
		
	public Compromisso getConvite() {
		return convite;
	}

}
