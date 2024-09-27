package Programa;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TesteBancoDigital {

	static Scanner input = new Scanner(System.in);

	
/* UMA LISTA DINÂMICA PARA ARMAZENAR CONTAS BANCÁRIAS */	
	static ArrayList<Conta> contasBancarias;
	
	
	
	
	public static void main(String[] args) {
		
/* LISTA QUE ARMAZENARÁ OBJETOS DO TIPO Conta */		
		contasBancarias = new ArrayList<Conta>();
		operacoes();	
	}
	
//---------------------------------------------------------------------------------------------------//
	
/* MÉTODO OPERAÇÕES */	
	public static void operacoes() {
		
		/* OBJETO CLASSE */
		Date hoje = new Date();
		
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println("--------------------BANCO 24 HORAS--------------------" );
		System.out.println();
		Locale.setDefault(new Locale("pt", "Brazil"));
		String Hoje = DateFormat.getDateTimeInstance().format(hoje);
		System.out.println("           Data: "+ Hoje                               );
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|              1 -   Criar Conta                     |");
		System.out.println("|              2 -   Depositar                       |");
		System.out.println("|              3 -   Sacar                           |");
		System.out.println("|              4 -   Transferir                      |");
		System.out.println("|              5 -   Listar                          |");
		System.out.println("|              6 -   Sair                            |");
		System.out.println("------------------------------------------------------");

		
		
/* SWITCH: ESCOLHER A OPERAÇÃO COM BASE NA OPÇÃO ESCOLHIDA */	
		
		System.out.println();
		System.out.println();
		System.out.print("Por gentileza, digite a opção desejada: ");
		int opcao = input.nextInt();
		System.out.println();
		System.out.println();
		
		
		switch(opcao) {
		case 1: 
			criarConta();
			break;
			
		case 2: 
			depositar();
			break;
			
		case 3: 
			sacar();
			break;
			
		case 4: 
			transferir();
			break;	
			
		case 5: 
			listarContas();
			break;
			
		case 6: 
			System.out.println("Saindo...");
		    System.exit(0);
		    
		default: 
			System.out.println("Opção inválida!"); //repetir se a operação for inválida
			operacoes();
			break;
		}
	}
	
	
/* MÉTODO CRIAR CONTA: LÊ OS DADOS DO USUÁRIO, CRIA UM OBJETO Pessoa E, EM SEGUIDA, UMA Conta ASSOCIADA
 * A ESSA PESSOA */
	public static void criarConta() {
		
		System.out.print("\nNome Completo: ");
		String nome = input.nextLine();
		input.nextLine();
		
		System.out.print("\nCPF (xxx.xxx.xxx-xx): ");
		String cpf = input.nextLine();

		System.out.print("\nEmail: ");
		String email = input.nextLine();
		input.nextLine();

		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");
		
		
		operacoes();
		
	}
	
/* MÉTODO ENCONTRAR CONTA: RESPONSÁVEL POR LOCALIZAR UMA CONTA BANCÁRIA NA LISTA DE CONTAS 
 * USANDO NÚMERO DA CONTA */
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;                   // indica conta não encontrada
		if(contasBancarias.size() > 0) {
			for(Conta c : contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
				  conta = c;
			}
		 }
      }		
	  return conta; //retorna conta encontrada ou null se não houver.
	
   }
	

/* MÉTODO DEPOSITAR: RESPONSÁVEL POR REALIZAR UM DEPÓSITO EM UMA CONTA BANCÁRIA */
	public static void depositar() {
		System.out.print("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {                      //Verifica se a conta foi encontrada.
			System.out.print("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			System.out.println();
			conta.depositar(valorDeposito);        //Chama o método depositar da classe conta
			System.out.println();
			System.out.println("Valor depositado com sucesso!");
		} else {
			System.out.println("Conta não encontrada! ");
		}
		
		operacoes();   //Chama o método operacoes() para retornar ao menu principal
		               
	}
	
	
/* MÉTODO SACAR: RESPONSÁVEL POR REALIZAR UM SAQUE EM SUA CONTA BANCÁRIA */	
	public static void sacar() {
		System.out.print("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.print("Qual valor deseja depositar? ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);                      //Chama o método sacar da classe conta
		} else {
			System.out.println("Conta não encontrada! ");
		}
		
		operacoes();   //Chama o método operacoes() para retornar ao menu principal
                       
	 }
	
	
/* MÉTODO TRANSFERIR: RESPONSÁVEL POR TRANSFERIR DINHEIRO EM UMA CONTA BANCÁRIA */	
	public static void transferir() {
		System.out.print("Número da conta do remetente: ");
		int numeroContaRemetente = input.nextInt();
        System.out.println();

		Conta contaRemetente = encontrarConta(numeroContaRemetente);           //Localizar a conta correspondente ao número fornecido
		
		if(contaRemetente != null) {
			System.out.print("Número da conta do destinatário: ");
			int numeroContaDestinatario = input.nextInt();
            System.out.println();
            
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);  //Localizar a conta do destinatário
			
			if(contaDestinatario != null) {                                    //Se a conta for encontrada, prossegue.
				System.out.print("Valor da transferência: ");
				Double valor = input.nextDouble();
	            System.out.println();

				contaRemetente.transferir(contaDestinatario, valor);         //Chama o método transferir da classe conta
			} else {   
				System.out.println("Conta para transferência não encontrada");
			}
		}
		operacoes();    //Chama o método operacoes() para retornar ao menu principal
                       
	}
	
	
/* MÉTODO LISTAR CONTAS */
	public static void listarContas() {
		if(contasBancarias.size() > 0) {   //Verificar se há contas cadastradas
			System.out.println("----- Listagem de Contas -----");
			for(Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
				System.out.println("Não tem contas cadastradas!");
		}
		
		operacoes();      //Chama o método operacoes() para retornar ao menu principal
		
		}
	}






/* RESUMO DO PROGRAMA:
 * CLASSE CONTA: MANIPULA DADOS E OPERAÇÕES ESPECÍFICAS DE CONTAS BANCÁRIAS. 
 * CLASSE MAIN: GERENCIA A INTERAÇÃO DO USUÁRIO E O FLUXO DO PROGRAMA.
*/
