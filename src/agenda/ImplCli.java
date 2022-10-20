package agenda;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class ImplCli extends UnicastRemoteObject implements InterfaceCli {
    
	String Nome;
	
	//	InterfaceServ referenciaServidor = null;

	public ImplCli(String N) throws RemoteException {
		super();
		this.Nome = N;
	}

	@Override
	public Date setNotificacao(String notificacao){
		System.out.println("[CLIENTE]: Recebi Notificação");
		return null;
	}

	@Override
	public Notificacao atulizarNotificao(String notificacao, int Hora, int Minuto, int Segundo){
		// TODO Auto-generated method stub
		return null;
	}

//    public InterfaceServ getServer() {
//        return this.referenciaServidor;
//    }

}
