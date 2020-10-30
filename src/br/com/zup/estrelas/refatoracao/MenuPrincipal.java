package br.com.zup.estrelas.refatoracao;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

	public static String imprimeMenuPrincipal() throws IOException {

		Scanner teclado = new Scanner(System.in);

		try {
			System.out.println("\n      BEM VINDO AO JOGO DA FORCA");
			System.out.println("===================================");
			System.out.print("\n");
			System.out.println("           [1] - NEW GAME");
			System.out.println("           [2] -  REGRAS");
			System.out.println("           [3]   - SAIR");
			System.out.println("\n===================================");

			System.out.print("\n      - DIGITE A OPÇÃO DESEJADA:");
			System.out.print("\n");
			byte opcaoMenu = teclado.nextByte();

			switch (opcaoMenu) {

			case 1:
				JogoDaForca.fazOSorteioDaPalavra();
				break;

			case 2:
				RegraDoJogo.imprimeMenuDeRegras();
				break;

			case 3:
				System.out.println("===================================");
				System.out.print("\n");
				System.out.println("      FIM DO JOGO, VOLTE SEMPRE.");
				System.out.print("\n");
				System.out.println("===================================");
				break;

			default:
				System.out.println("OPÇÃO INVÁLIDA!");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("===================================");
			System.out.print("\n");
			System.out.println("       DIGITE SOMENTE NUMERO !");
			System.out.print("\n");
			System.out.println("===================================");
			imprimeMenuPrincipal();
		}

		teclado.close();
		return null;
	}
}
