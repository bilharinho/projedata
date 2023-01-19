package projedata;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		ArrayList<Funcionario> empresa = new ArrayList<Funcionario>();
		
		BigDecimal totalSalarios = new BigDecimal("0");
		
		DecimalFormat formatadorSal = new DecimalFormat("##,###,##0.00");    
		
		// montagem da tabela
		empresa.add(new Funcionario("Maria",LocalDate.parse("18/10/2000", formatador),
				new BigDecimal(2009.44),"Operador"));
		
		empresa.add(new Funcionario("João",LocalDate.parse("12/05/1990", formatador),
				new BigDecimal(2284.38),"Operador"));
		
		empresa.add(new Funcionario("Caio",LocalDate.parse("02/05/1961", formatador),
				new BigDecimal(9836.14),"Coordenador"));
		
		empresa.add(new Funcionario("Miguel",LocalDate.parse("14/10/1988", formatador),
				new BigDecimal(19119.88),"Diretor"));
		
		empresa.add(new Funcionario("Alice",LocalDate.parse("05/01/1995", formatador),
				new BigDecimal(2234.68),"Recepcionista"));
		
		empresa.add(new Funcionario("Heitor",LocalDate.parse("19/11/1999", formatador),
				new BigDecimal(1582.72),"Operador"));
		
		empresa.add(new Funcionario("Arthur",LocalDate.parse("31/03/1993", formatador),
				new BigDecimal(4071.84),"Contador"));
		
		empresa.add(new Funcionario("Laura",LocalDate.parse("08/07/1994", formatador),
				new BigDecimal(3017.45),"Gerente"));	
		
		empresa.add(new Funcionario("Heloisa",LocalDate.parse("25/04/2003", formatador),
				new BigDecimal(1606.85),"Eletricista"));
		
		empresa.add(new Funcionario("Helena",LocalDate.parse("02/09/1996", formatador),
				new BigDecimal(2799.93),"Gerente"));		
		
		// remoção João
		int i = 0;
		int iPosicaoJoao = 0 ;
		
		for(Funcionario fu : empresa) {
			i++;
			if(fu.getNome().equals("João")) 
				iPosicaoJoao = i;
		}	
		
		empresa.remove(iPosicaoJoao);
		
		
		// exibição dos valores
		System.out.println("Funcionários:");
		for(Funcionario fu : empresa) {
			System.out.println(fu.dadosFuncionario());			
		}		
		System.out.println(" ");
		
		System.out.println("Com aumento 10%");
		// aumento 10pc
		for(Funcionario fu : empresa) {
			fu.setSalario(fu.getSalario().multiply(new BigDecimal("1.1")));			
		}
		
		// exibição dos valores com aumento
		for(Funcionario fu : empresa) {
			totalSalarios = totalSalarios.add(fu.getSalario());
			System.out.println(fu.dadosFuncionario());			
		}	
		System.out.println(" ");
		
		// valores em salários mínimos
		System.out.println("valores em salários mínimos");
		for(Funcionario fu : empresa) {
			System.out.println(fu.getNome() + ", " + 
					formatadorSal.format(fu.getSalario().divide(new BigDecimal("1212"), new MathContext(2, RoundingMode.HALF_EVEN))));			
		}	
		System.out.println(" ");		
		
		//Total Salários
		System.out.println("Total Salários: " + formatadorSal.format(totalSalarios));
		
	}

}
