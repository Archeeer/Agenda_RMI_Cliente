package agenda;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class VerificaAssinatura {
	PublicKey chavePublica;

	public VerificaAssinatura(PublicKey chavePublica) {
		super();
		this.chavePublica = chavePublica;
		// TODO Auto-generated constructor stub
	}

	public boolean DoSomething(String mensagem, byte [] assinado) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
		Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
		sig.initVerify(chavePublica);
		sig.update(mensagem.getBytes());
		return sig.verify(assinado);
	}
}
