package br.com.caelum.java8.aula3;

import java.util.ArrayList;
import java.util.List;

/**
 * Metodos reference é so uma forma de 
 * escrever lambdas de uma maneira mais enxuta e deixar o código mais legível.
 * São estáticos por natureza. Ex. Comparator.comparing(funcao);
 * @author starks
 *
 */
public class MethodReferences {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		// método reference
//		Function<String, Integer> funcao = s -> s.length(); //ou = String::length;
//		Comparator<String> comparadorReference = Comparator.comparing(funcao);
//		palavras.sort(comparadorReference);
		// ou
//		palavras.sort(Comparator.comparing(s -> s.length()));
		// ou comparação por tamanho
//		palavras.sort(Comparator.comparing(String::length));
		// ou comparação por ordem alfabética
//		palavras.sort(Comparator.comparing(String::toString));
		// ou usando compareToIgnoreCase(s)
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		palavras.forEach(System.out::println);
		
		/**
		 * Considere o seguinte código que executa um Runnable em uma Thread
		 * Como podemos escreve-lo usando a uma expressão lambda?
		 * 
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start(); 
		*/
		
//		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
		// Via metodo reference não imprimi nada, porque o método run() de Thread não recebe parâmetro.
		// Esse lambda não pode ser escrito como method reference também, porque
		// não é uma simples invocação de métodos onde os parâmetros são os mesmos que os do lambda.
		new Thread(System.out::println).start();
	}

}
