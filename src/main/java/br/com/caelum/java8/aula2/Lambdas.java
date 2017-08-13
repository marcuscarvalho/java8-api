package br.com.caelum.java8.aula2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Lambda são funções, ou seja, uma interface
 * com um único método abstrato - podendo ter outros métodos
 * concretos default.
 * @author starks
 *
 */
public class Lambdas {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		Comparator<String> comparador = (o1, o2) -> Integer.compare(o1.length(), o2.length());
		palavras.sort(comparador);
		// ou
//		palavras.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));
		
		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor); 
		// ou
//		palavras.forEach(s -> System.out.println(s));
		
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
		
		new Thread(() -> System.out.println("Executando um Runnable")).start(); 
	}

}
