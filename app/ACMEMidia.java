package app;

import dados.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ACMEMidia {

	private Midiateca midiateca;
	private Scanner entrada;
	private PrintStream saidaPadrao = System.out;

	/**
	 *
	 *
	 */
	public ACMEMidia() {
		try {
			BufferedReader streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
			entrada = new Scanner(streamEntrada);
			entrada.useDelimiter("[;\n\r]");
			PrintStream streamSaida = new PrintStream(new File("dadosout.txt"), StandardCharsets.UTF_8);
			System.setOut(streamSaida);
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);
		midiateca = new Midiateca();
	}

	public void executa() {
		cadastrarVideos();//1
		cadastrarMusicas();//2
		mostrarDadosDeUmaDeterminadaMidia();//3
		mostrarDadosdeMidiaDeUmaDeterminadaCategoria();//4
		mostrarDadosDeVideoDeUmaDeterminadaQualidade();//5
		mostrarDadosDaMusicaMaiorDuracao();//6
		removerUmaMidia();//7
		mostrarSomatorioLocacoesDeTodasMidias();//8
	}

	//Método 1
	private void cadastrarVideos(){
		int codigo;
		String titulo;
		int ano;
		String categoria;
		int qualidade;
		Video video;
		codigo = entrada.nextInt();
		while(codigo !=-1) {
			titulo = entrada.nextLine();
			ano = entrada.nextInt();
			entrada.nextLine();
			categoria = entrada.nextLine();
			qualidade = entrada.nextInt();
			video = new Video(codigo, titulo, ano, Categoria.valueOf(categoria), qualidade);
			if (midiateca.cadastraMidia(video)) {
				System.out.println("1:" + codigo + ", " + titulo + ", " + ano + "; " + categoria + ", " + qualidade);
			}
			codigo = entrada.nextInt();
		}
	}

	//Método 2
	private void cadastrarMusicas() {
		int codigo;
		String titulo;
		int ano;
		String categoria;
		Double duracao;
		Musica musica;

		codigo = entrada.nextInt();
		while (codigo != -1) {
			titulo = entrada.nextLine();
			ano = entrada.nextInt();
			entrada.nextLine();
			categoria = entrada.nextLine();
			duracao = entrada.nextDouble();
			musica = new Musica(codigo, titulo, ano, Categoria.valueOf(categoria), duracao);
			if (midiateca.cadastraMidia(musica)) {
				System.out.println("2:" + codigo + ", " + titulo + ", " + ano + "; " + categoria + ", " + duracao);
			}
			codigo = entrada.nextInt();
		}
	}

	//Método 3
	private void mostrarDadosDeUmaDeterminadaMidia() {
		int codigo;
		codigo = entrada.nextInt();
		Midia midia = midiateca.consultaPorCodigo(codigo);
		if(midia !=null){
			if(midia instanceof Video) {
				Video video = (Video) midia;
				System.out.println("3:" + codigo + ", " + midia.getTitulo() + ", " + midia.getAno() + "; " + video.getCategoria() + ", " + video.getQualidade()+ ", " + video.calculaLocacao());
			}else{
				Musica musica = (Musica) midia; //Converte variavel do tipo Midia para o tipo Musica.
				System.out.println("3:" + codigo + ", " + midia.getTitulo() + ", " + midia.getAno() + "; " + musica.getCategoria() + ", " + musica.getDuracao()+ ", " + musica.calculaLocacao());
			}
		}
	}

	//Método 4
	private void mostrarDadosdeMidiaDeUmaDeterminadaCategoria() {
		String categoria;
		categoria = entrada.nextLine();
		ArrayList<Midia> temp = midiateca.consultaPorCategoria(Categoria.valueOf(categoria));
		if(temp.size() == 0){ //Verifico se o Array é igual, igual a zero.
			System.out.println("4:Nenhuma midia encontrada.");
		}else{
			for (Midia midiaAux: temp) {
				System.out.println("4" + midiaAux.getData());
			}
		}
	}

	//Método 5
	private void mostrarDadosDeVideoDeUmaDeterminadaQualidade() {
	}

	//Método 6
	private void mostrarDadosDaMusicaMaiorDuracao() {
	}

	//Método 7
	private void removerUmaMidia() {
	}

	//Método 8
	private void mostrarSomatorioLocacoesDeTodasMidias() {
	}
}
