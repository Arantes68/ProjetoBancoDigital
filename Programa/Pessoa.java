package Programa;

public class Pessoa {

/* CONTADOR ESTÁTICO QUE RASTREIA O NÚMERO DE PESSOAS CRIADAS */	
	private static int counter = 1;
	
	
/* ATRIBUTOS */	
	private String nome;
	private String cpf;
	private String email;
	
	
/* CONSTRUTOR: INICIALIZA OS ATRIBUTOS DA PESSOA E INCREMENTA O CONTADOR */	
	public Pessoa(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		counter += 1;
	}


/* MÉTODOS ESPECIAIS: PARA ACESSAR (GET) E MODIFICAR (SET) */
	public static int getCounter() {
		return counter;
	}


	public static void setCounter(int counter) {
		Pessoa.counter = counter;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


/* toString: RETORNA UMA REPRESENTAÇÃO TEXTUAL DOS DADOS PESSOA */	
	@Override
	public String toString() {
		return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCpf() + 
                 "\nEmail: " + this.getEmail();
	}	
	
}
