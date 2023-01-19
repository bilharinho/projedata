package projedata;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa{
	
    private BigDecimal salario;
    private String funcao;
    
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     
    DecimalFormat formatadorSal = new DecimalFormat("##,###,##0.00");    
    
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, 
			String funcao) {
		super();
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.setSalario(salario);
		this.setFuncao(funcao);
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}	
	
	public String dadosFuncionario() {
		
		String saida;
		
		saida = this.getNome() + ", " +
				this.getDataNascimento().format(formatadorData) + ", " +
				formatadorSal.format(this.getSalario()) + ", " +
				this.getFuncao();
		
		return saida;		
	}

}
