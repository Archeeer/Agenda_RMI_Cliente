package agenda;
import java.util.ArrayList;

public class Compromisso  {
	public String Nome;
	public String Data;
	public int Hora;
	public int Minuto;
	public int Segundo;
	
	ArrayList<Usuario> Convidados = new ArrayList<>();
	ArrayList<Notificacao> listaNotificacao = new ArrayList<>();
    

    public Compromisso(String Nome, String Data, int Hora, int Minuto, int Segundo, ArrayList<Usuario> Convidados) {
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

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public int getHora() {
		return Hora;
	}

	public void setHora(int hora) {
		Hora = hora;
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
    
    
    

}
