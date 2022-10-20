package agenda;

import java.util.Scanner;

public class Menu {

	public int menu() {
		System.out.println("Menu:");
		System.out.println("  1. Cadastro de Compromisso");
		System.out.println("  2. Cancelamento de Compromisso");
		System.out.println("  3. Cancelamento de Alerta");
		System.out.println("  4. Consulta de Compromisso");
		Scanner menu = new Scanner(System.in);
		int opcao = menu.nextInt();
		return opcao;
	}
}
