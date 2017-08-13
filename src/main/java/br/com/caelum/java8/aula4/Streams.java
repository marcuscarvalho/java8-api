package br.com.caelum.java8.aula4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 * 
 * @author starks
 *
 */
public class Streams {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		// transforming "Curso" stream to a "nome do curso" stream
		Stream<String> nomeCursoStream = cursos.stream()
			.map(c -> c.getNome());
		
		nomeCursoStream.forEach(System.out::println);
		
		// or in a fluent way
		cursos.stream()
			.map(c -> c.getNome())
			.forEach(c -> System.out.println(c));
		
		// or using method reference
		cursos.stream()
			.map(Curso::getNome)
			.forEach(System.out::println);
		
		// without map
		cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.sorted(Comparator.comparingInt(c -> c.getAlunos()))
//			.forEach(System.out::println); // prints the object reference id
			.forEach(c -> System.out.println(c.getAlunos()));
		
		// with lambdas
		cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.sorted(Comparator.comparing(c -> c.getAlunos()))
			.mapToInt(c -> c.getAlunos())  // or with Stream<Integer> autoboxing .map(c -> c.getAlunos())
			.forEach(total -> System.out.println(total));
		
		// or with method reference
		cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.sorted(Comparator.comparing(Curso::getAlunos))
			.mapToInt(Curso::getAlunos) // or with Stream<Integer> autoboxing .map(c -> c.getAlunos())
			.forEach(System.out::println);
		
		// sum
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.mapToInt(Curso::getAlunos)
			.sum();
		
		System.out.println(sum);
		
		// http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
		// Alguns bem interessante são map, collect, findFirst e findAny
		
	}

}

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}
