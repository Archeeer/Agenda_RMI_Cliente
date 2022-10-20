package agenda;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Compromisso implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String Nome;
	public LocalDate Data;
	public LocalTime Hora;

	ArrayList<Usuario> Convidados = new ArrayList<>();
//	ArrayList<Alerta> listaNotificacao = new ArrayList<>();


    public Compromisso(String Nome, LocalDate Data, LocalTime Hora, ArrayList<Usuario> Convidados) {
        this.Nome = Nome;
    	this.Data = Data;
        this.Hora = Hora;
        this.Convidados = Convidados;
    }

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public LocalDate getData() {
		return Data;
	}

	public void setData(LocalDate data) {
		Data = data;
	}

	public LocalTime getHora() {
		return Hora;
	}

	public ArrayList<Usuario> getConvidados() {
		return Convidados;
	}

	public void setHora(LocalTime hora) {
		Hora = hora;
	}

	@Override
	public String toString() {
		return  "Nome: " + this.getNome() +
				", Data: " + this.getData() +
				", Hora: " + this.getHora() +
				", Convidados: ";
	}

	@Override
	public boolean equals(Object arg0) {
	    return this.Nome.equals(((Compromisso) arg0).Nome);
	}
}

//	public String getNotificacao() {
//		return Notificacao;
//	}
//
//	public void setNotificacao(String notificacao) {
//		Notificacao = notificacao;
//	}

//	public ArrayList<String> getConvidados() {
//		return listaConvidados;
//	}
//
//	public void setConvidados(byte[] convidados) {
//		listaConvidados = convidados;
//	}
