package agenda;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;

public class ImplCli extends UnicastRemoteObject implements InterfaceCli {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String Nome;
	InterfaceServ refServidor;
	byte [] compAssinado;
	Compromisso convite;
	PublicKey chavePublica;
	PrivateKey chavePrivada;
	VerificaAssinatura verificador;
	
	public ImplCli(String N, InterfaceServ refServidor) throws RemoteException {
		super();
		this.Nome = N;
		this.refServidor = refServidor;
	}

	public PublicKey getChavePublica() {
		return chavePublica;
	}

	public void setChavePublica(PublicKey chavePublica) {
		this.chavePublica = chavePublica;
		verificador = new VerificaAssinatura(chavePublica);
	}

	public PrivateKey getChavePrivada() {
		return chavePrivada;
	}

	public void setChavePrivada(PrivateKey chavePrivada) {
		this.chavePrivada = chavePrivada;
	}

	@Override
	public void mostrarAlerta(String infoCompromisso) {
		System.out.println("[CLIENTE]: Alerta recebido");
		System.out.println("[CLIENTE]: " + infoCompromisso);
	}

	@Override
	public void mostrarConvite(Compromisso convite, byte [] compAssinado) throws RemoteException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, SignatureException {
		
		this.convite = convite;
		String f = convite.toString() + "\n" + convite.Convidados.toString() + '\n';
		this.compAssinado = compAssinado;
		
		if(verificador.DoSomething(f,compAssinado) == true )	{	
			System.out.println("[CLIENTE]: Convite recebido, assinatura valida \n");
			System.out.println(convite + " \n");
			System.out.println(convite.Convidados + "\n");
			System.out.println("[CLIENTE]: Gostaria de receber um Alerta? 5 para sim");
		} else {

			System.out.println("[CLIENTE]: Convite recebido\n");
			System.out.println("[CLIENTE]: Assinatura inválida");
		}
	}

	public Compromisso getConvite() {
		return convite;
	}
}
