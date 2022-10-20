package agenda;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private InterfaceCli refCliente;

	public Usuario(String nome, InterfaceCli cliente){
		this.nome = nome;
		this.setCliente(cliente);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public InterfaceCli getCliente() {
		return refCliente;
	}

	public void setCliente(InterfaceCli refCliente) {
		this.refCliente = refCliente;
	}

	@Override
	public String toString() {
	    return "Nome: " + this.getNome();
	    }

}
