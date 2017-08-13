package br.com.caelum.java8.aula5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * http://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
 * 
 * @author starks
 *
 */
public class Optionals {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		Optional<Curso> curso = cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny();
		
		// Pegar o primeiro elemento
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst()
		   .ifPresent(c -> System.out.println(c.getNome()));
		
//		Curso curso = optional.get();
		
//		Curso curso = optional.orElse(null);
		
//		Curso curso = optional.ifPresent(c -> System.out.println(c.getNome()));
		
//		cursos.stream()
//		   .filter(c -> c.getAlunos() > 100)
//		   .findAny()
//		   .ifPresent(c -> System.out.println(c.getNome()));
		
		
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
