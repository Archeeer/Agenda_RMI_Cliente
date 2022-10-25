package agenda;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;

public interface InterfaceCli extends Remote {

	public void mostrarAlerta(String infoCompromisso) throws RemoteException;
	public void mostrarConvite(Compromisso compromisso, byte[] compAssinado) throws RemoteException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, SignatureException;
	public Compromisso getConvite() throws RemoteException;
	public PublicKey getChavePublica()throws RemoteException;
	public void setChavePublica(PublicKey chavePublica)throws RemoteException;
	public PrivateKey getChavePrivada()throws RemoteException;
	public void setChavePrivada(PrivateKey chavePrivada)throws RemoteException;

}