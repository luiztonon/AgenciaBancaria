package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
		
	}
	
	public static void operacoes() {
		
		System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");
        
        int operacao = input.nextInt();

        switch (operacao) {
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
                System.out.println("Obrigado por usar nossos serviços!");
                System.exit(0); 
                
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }
	
	public static void criarConta() {
		
		System.out.println("\nNome: ");
		String nome = input.next();
		
		System.out.println("\nCpf: ");
		String cpf = input.next();
		
		System.out.println("\nEmail: ");
		String email = input.next();
		
		Cliente cliente = new Cliente(nome, cpf, email);
		
		Conta conta = new Conta(cliente);
		
		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");
		
		operacoes();
		
}
	
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta);
				conta = c;
				
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor deseja depositar?");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!");
		} else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();

}

public static void sacar() {
	System.out.println("Número da conta: ");
	int numeroConta = input.nextInt();

	Conta conta = encontrarConta(numeroConta);

	if (conta != null) {
		System.out.println("Qual valor deseja sacar? ");
		Double valorSaque = input.nextDouble();
		conta.sacar(valorSaque);
		System.out.println("Valor sacado com sucesso! ");
	} else {
		System.out.println("Conta não encontrada!");
	}
	operacoes();
}

public static void transferir() {
	System.out.println("Número da conta que vai enviar a transferência: ");
	int numeroContaRemetente = input.nextInt();

	Conta contaRemetente = encontrarConta(numeroContaRemetente);

	if (contaRemetente != null) {
		System.out.println("Número da conta do destinatário: ");
		int numeroContaDestinatario = input.nextInt();

		Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

		if (contaDestinatario != null) {
			System.out.println("Valor da transferência: ");
			Double valor = input.nextDouble();

			contaRemetente.transferir(contaDestinatario, valor);
		}

	}
	operacoes();
}

public static void listarContas() {
	if (contasBancarias.size() > 0) {
		for (Conta conta : contasBancarias) {
			System.out.println(conta);
		}
	} else {
		System.out.println("--- Não há contas cadastradas ---");
	}

	operacoes();
}
}
