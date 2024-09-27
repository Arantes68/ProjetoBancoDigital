package Programa;

/* IMPORTANDO A CLASSE UTILS */
import utilitarios.utils;

public class Conta {
	
	
/* CONTADOR ESTÁTICO QUE RASTREIA O NÚMERO DE CONTAS CRIADAS */
	private static int contadorDeContas = 1;
	
	
/* ATRIBUTOS */	
	private int numeroConta;
	private Pessoa pessoa;    //Associação com a classe pessoa
	private Double saldo = 0.0;
	
	
/* CONSTRUTOR: numeroConta COM O VALOR DO CONTADOR (VAI GERAR UM NUMERO DE CONTA AUTOMÁTICA)
 * E ASSOCIA UMA Pessoa À CONTA */	
	public Conta(Pessoa pessoa) {
		this.numeroConta = contadorDeContas;  
		this.pessoa = pessoa;
		contadorDeContas += 1;
	}

	
/* MÉTODOS ESPECIAIS PARA ACESSAR (GET) E MODIFICAR (SET) */
	public static int getContadorDeContas() {
		return contadorDeContas;
	}


	public static void setContadorDeContas(int contadorDeContas) {
		Conta.contadorDeContas = contadorDeContas;
	}


	public int getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


/* toString: RETORNA UMA APRESENTAÇÃO TEXTUAL DOS DADOS DA CONTA */
	@Override
	public String toString() {
		return "\nNumero da conta: " + this.getNumeroConta() +
		       "\nNome: " + this.pessoa.getNome() +
		       "\nCPF: " + this.pessoa.getCpf() +
		       "\nEmail: " + this.pessoa.getEmail() +
		       "\nSaldo: " + utils.doubleToString(this.getSaldo());
	}

	
/* MÉTODO: DEPOSITAR */	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
		}else {
			System.out.println("Não foi possível realizar o depósito!");
		}
 	}
	
	
/* MÉTODO: SACAR */	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}
	
	
/* MÉTODO: TRANSFERIR */	
	public void transferir(Conta contaParaDeposito, double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Não foi possível realizar a transferência!");
		}
	}
}
