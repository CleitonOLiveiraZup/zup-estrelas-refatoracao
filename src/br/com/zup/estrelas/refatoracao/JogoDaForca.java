package br.com.zup.estrelas.refatoracao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JogoDaForca {

	
	public static String fazOSorteioDaPalavra() throws IOException {
		
		String linha;
		int numeroMaximoDePalavras = 7;
		String[] palavrasAleatoria = new String[numeroMaximoDePalavras];

		int contagem = 0;

		Random random = new Random();

		FileReader estrutura = new FileReader("java-arquivo.txt");
		BufferedReader leitor = new BufferedReader(estrutura);

		while ((linha = leitor.readLine()) != null) {
			palavrasAleatoria[contagem] = linha;
			contagem++;
		}
		int quantPalavras = palavrasAleatoria.length;
		int indiceSorteado = random.nextInt(quantPalavras);

		String palavraEscolhidaParaForca = palavrasAleatoria[indiceSorteado];
		char[] letraCorreta = new char[palavraEscolhidaParaForca.length()];

		for (int i = 0; i < letraCorreta.length; i++) {
			letraCorreta[i] = 0;

		}
		ocultaPalavraDaForca(palavraEscolhidaParaForca, letraCorreta);
		return null;

	}

	public static String ocultaPalavraDaForca(String palavraEscolhidaParaForca, char[] letraCorreta) throws IOException {
		Scanner teclado = new Scanner(System.in);

		String letraDigitada = " ";
		char acertos = ' ';
		byte vida = 6;
		boolean defineSeJogadorGanhuOJogo = false;
		boolean letraRepetida = false;
		String letraJaDigitada = "";

		while (!defineSeJogadorGanhuOJogo) {

			System.out.println("===================================");
			System.out.print("\n");
			System.out.println("      - LETRAS UTILIZADAS " + letraDigitada);
			System.out.print("\n");
			System.out.println("      - A PALAVRA TEM " + palavraEscolhidaParaForca.length() + " LETRAS");
			System.out.print("\n");
			System.out.println("      - VOCÊ TEM " + vida + " VIDAS");
			System.out.print("\n");
			System.out.println("      - DIGITE UMA LETRA.");
			System.out.println("\n===================================");
			System.out.print("\n");
			char letra = teclado.next().toUpperCase().charAt(0);
			String letras = String.valueOf(letra);
			System.out.print("\n");
			palavraEscolhidaParaForca = removePontuacao(palavraEscolhidaParaForca);
			letras = removePontuacao(letras);
			letraDigitada += " " + letras;

			boolean percaDeVidas = true;

			letraRepetida = vereficaLetraRepetida(letras, letraJaDigitada, percaDeVidas);

			if (letraRepetida != true) {
				for (int i = 0; i < palavraEscolhidaParaForca.length(); i++) {
					if (letras.equals(String.valueOf(palavraEscolhidaParaForca.charAt(i)))) {
						letraCorreta[i] = 1;
						letraJaDigitada += letras;
						percaDeVidas = false;
					}

				}
			} else {
				System.out.println("     POXA LETRA JÁ UTILIZADA !");
				percaDeVidas = false;
			}

			if (percaDeVidas) {
				letraJaDigitada += letras;
				vida--;
			}

			defineSeJogadorGanhuOJogo = true;

			for (int i = 0; i < palavraEscolhidaParaForca.length(); i++) {
				if (acertos == palavraEscolhidaParaForca.charAt(i)) {

					System.out.print(" ");

				} else if (letraCorreta[i] == 0) {
					System.out.print(" _ ");
					defineSeJogadorGanhuOJogo = false;

				} else {
					System.out.print(" " + palavraEscolhidaParaForca.charAt(i) + " ");

				}
			}
			System.out.print("\n");
			System.out.print("\n");

		

			if (vida == 0) {
				imprimeFimDoJogoPerdedor(vida, palavraEscolhidaParaForca);
				break;
			}
		}
		impremeFimDoJogoVencendor(vida, defineSeJogadorGanhuOJogo);

		teclado.close();

		return null;

	}

    public static String removePontuacao(String texto) {
		
		String nfdNormalizedString = Normalizer.normalize(texto, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	
	public static boolean vereficaLetraRepetida(String letras, String letraRepeditas, boolean percaDeVidas) {

		for (int i = 0; i < letraRepeditas.length(); i++) {
			if (letras.equals(String.valueOf(letraRepeditas.charAt(i)))) {

				return true;

			}

		}
		percaDeVidas = false;
		return false;

	}

	public static String impremeFimDoJogoVencendor(byte vida, boolean defineSeJogadorGanhuOJogo) throws IOException {
		Scanner teclado = new Scanner(System.in);

		if (defineSeJogadorGanhuOJogo = true && vida != 0) {
			System.out.println("\n===================================");
			System.out.print("\n");
			System.out.println("        PARABENS VOCE GANHOU.");
			System.out.println("             ___________      ");
			System.out.println("            '._==_==_=_.'     ");
			System.out.println("            .-\\:      /-.    ");
			System.out.println("           | (|:.     |) |    ");
			System.out.println("            '-|:.     |-'     ");
			System.out.println("              \\::.    /      ");
			System.out.println("               '::. .'        ");
			System.out.println("                 ) (          ");
			System.out.println("               _.' '._        ");
			System.out.println("              '-------'       ");
			System.out.print("\n");
			System.out.println("VOCE PODE ADICIONAR UMA NOVA PALAVRA.");
			System.out.println("===================================");
			System.out.print("\n");
			System.out.println("    [1] - VOLTAR AO MENU PRINCIPAL");
			System.out.println("    [2] -     NOVA PALAVRA");
			System.out.println("    [3] -         SAIR");
			System.out.print("\n");
			System.out.println("\n===================================");
		}
		try {
			byte opcaoMenuGanhador = teclado.nextByte();

			switch (opcaoMenuGanhador) {
			case 1:
				MenuPrincipal.imprimeMenuPrincipal();
				break;
			case 2:
				adicionarPalavraNoArquivoTxt();
				break;
			case 3:
				System.out.println("===================================");
				System.out.print("\n");
				System.out.println("      FIM DO JOGO, VOLTE SEMPRE.");
				System.out.print("\n");
				System.out.println("\n===================================");
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
				break;
			}

		} catch (InputMismatchException e) {
			System.out.println("===================================");
			System.out.print("\n");
			System.out.println("      DIGITE SOMENTE NUMERO !");
			System.out.print("\n");
			System.out.print("  ===================================");
			impremeFimDoJogoVencendor(vida, defineSeJogadorGanhuOJogo);
		}

		teclado.close();
		return null;

	}
	
	public static void abrirArquivoParaEscrita(String nome, String linha) {
		
		FileWriter fwArquivo;
		BufferedWriter bwArquivo;
		try {
			File arquivo = new File(nome);

			fwArquivo = new FileWriter(arquivo, arquivo.exists());
			bwArquivo = new BufferedWriter(fwArquivo);

			bwArquivo.write(linha + '\n');

			bwArquivo.close();
			fwArquivo.close();

		} catch (IOException e) {
			System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
		}
	}

	public static String adicionarPalavraNoArquivoTxt() {
		Scanner input = new Scanner(System.in);
		String nomeDoArquivo = "java-arquivo.txt";

		System.out.println("Escrevendo no arquivo");
		String adicionaPalavra = input.nextLine();

		abrirArquivoParaEscrita(nomeDoArquivo, adicionaPalavra);

		System.out.println("PALAVRA SALVA COM SUCESSO");
		return null;
	}

	public static String imprimeFimDoJogoPerdedor(byte vida, String palavraEscolhidaParaForca) throws IOException {
		
		Scanner teclado = new Scanner(System.in);

		System.out.println("\n=========== GAME OVER===============");
		System.out.print("\n");
		System.out.println("            ____________");
		System.out.println("           |      |     |");
		System.out.println("           |      O     |");
		System.out.println("           |     -|-    |");
		System.out.println("           |      |     |");
		System.out.println("           |     / \\    |");
		System.out.println("            ____________");
		System.out.print("\n");
		System.out.println(" POXA A PALAVRA ERA : " + palavraEscolhidaParaForca);
		System.out.println("\n===================================");
		System.out.print("\n");
		System.out.println("    [1] - VOLTAR AO MENU PRINCIPAL");
		System.out.println("    [2] -          SAIR");
		System.out.print("\n");
		System.out.println("\n===================================");

		try {
			byte opcaoPerdedor = teclado.nextByte();

			switch (opcaoPerdedor) {

			case 1:
				MenuPrincipal.imprimeMenuPrincipal();
				break;

			case 2:
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
			System.out.println("      DIGITE SOMENTE NUMERO !");
			System.out.print("\n");
			System.out.println("===================================");
			imprimeFimDoJogoPerdedor(vida, palavraEscolhidaParaForca);
		}

		return null;

	}
	
	public static void main(String[] args) throws IOException {
	
		MenuPrincipal.imprimeMenuPrincipal();

	}

}