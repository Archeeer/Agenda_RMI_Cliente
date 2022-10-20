package agenda;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface InterfaceCli extends Remote {

//	InterfaceServ getServer();
//	public void notificarCompromisso(Compromisso C);
//	public void conviteCompromisso(Compromisso C);
	public Date setNotificacao(String notificacao) throws RemoteException;
	public Notificacao atulizarNotificao(String notificacao,int Hora,int Minuto,int Segundo)throws RemoteException;
	public void mostrarAlerta(String infoCompromisso) throws RemoteException;
}