package br.com.caelum.java8.aula5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectors {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		List<Curso> resultados = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .collect(Collectors.toList());
		
		Map mapa = cursos 
				.stream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		// Quantidade média de alunos 
		cursos.stream()
			.mapToInt(Curso::getAlunos)
			.average()
			.ifPresent(System.out::println);
		
		// From Stream<Curso> to List<Curso>
		cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.collect(Collectors.toList());
		
	}

}
