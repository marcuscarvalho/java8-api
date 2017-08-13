package br.com.caelum.java8.aula6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class JavaTime {
	
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(dtf.format(hoje));
        
        LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
        System.out.println(dataFutura);
        
        Period periodo = Period.between(hoje, dataFutura);
        System.out.println(periodo.getYears());
        
        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
        
        int anos = olimpiadasRio.getYear() - hoje.getYear();
        System.out.println(anos);
        
        periodo = Period.between(hoje, olimpiadasRio);
        System.out.println(periodo);
        
        periodo = Period.between(hoje, olimpiadasRio);
        System.out.println(periodo.getYears());
        System.out.println(periodo.getMonths());
        System.out.println(periodo.getDays());
        
        System.out.println(hoje.minusYears(1));
        System.out.println(hoje.minusMonths(4));
        System.out.println(hoje.minusDays(2));

        System.out.println(hoje.plusYears(1));
        System.out.println(hoje.plusMonths(4));
        System.out.println(hoje.plusDays(2));
        
        LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
        System.out.println(proximasOlimpiadas);
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String valorFormatado = proximasOlimpiadas.format(formatador);
        System.out.println(valorFormatado);
        
        LocalDateTime agora = LocalDateTime.now();
        
        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println(agora.format(formatadorComHoras));
        
        YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);
        
        LocalTime intervalo = LocalTime.of(12, 30);
        System.out.println(intervalo);
        
	}

}
