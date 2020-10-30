package br.com.zup.estrelas.refatoracao;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegraDoJogo {

	public static void imprimeMenuDeRegras() throws IOException {

		Scanner teclado = new Scanner(System.in);

		try {
			System.out.println("\n                       REGRAS");
			System.out.println("======================================================================");
			System.out.println("    -  VOC� INICIA O JOGO COM 6 VIDAS.");
			System.out.print("\n");
			System.out.println("    -  CADA LETRA QUE VOCE ERRAR PERDER 1 VIDA.");
			System.out.print("\n");
			System.out.println("    -  SE VOC� COLOCAR A MESMA LETRA MAIS DE 1 VEZ N�O IRA PERDER VIDA. ");
			System.out.print("\n");
			System.out.println("    -  CASO SAIBA A PALAVRA VOCE PODE DIGITAR A QUALQUER MOMENTO COM");
			System.out.println("       ESPA�O ENTRE AS LETRAS.");
			System.out.print("\n");
			System.out.println("    -  SE VOCE ACERTAR A PALAVRA TEM DIREITO DE ADICIONAR UMA NOVA.");
			System.out.println("======================================================================");
			System.out.print("\n");
			System.out.println("                       [3]  - VOLTAR");

			System.out.print("\n                  DIGITE A OP��O DESEJADA:");
			System.out.print("\n");
			System.out.println("======================================================================");
			byte opcaoMenuRegras = teclado.nextByte();

			switch (opcaoMenuRegras) {

			case 3:
				MenuPrincipal.imprimeMenuPrincipal();
				break;

			default:
				System.out.print("\n");
				System.out.println("======================================================================");
				System.out.print("\n");
				System.out.println("- OP��O INV�LIDA!");
				System.out.print("\n");
				System.out.println("======================================================================");
				imprimeMenuDeRegras();
				break;

			}
		} catch (InputMismatchException e) {
			System.out.println("======================================================================");
			System.out.print("\n");
			System.out.println("- DIGITE SOMENTE NUMERO !");
			System.out.print("\n");
			System.out.println("======================================================================");
			imprimeMenuDeRegras();
		}

		teclado.close();
	}

}
