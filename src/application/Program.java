package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pessoa> list = new ArrayList<>();

		System.out.print("Entre com a quantidade de pessoas: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Pessoa #" + i + " dados: ");
			System.out.print("Pessoa Física ou Jurídica (f/j): ");
			char op = sc.next().charAt(0);

			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda Anual: ");
			double rendaAnual = sc.nextDouble();

			if (op == 'f') {
				System.out.print("Gastos com saúde: ");
				double gastos = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastos));
			} else {
				System.out.print("Número de funcionários: ");
				int numeroFuncionario = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionario));
			}
		}
		
		double soma = 0.0;
		
		System.out.println();
		System.out.println("Pessoas: ");
		for (Pessoa p: list) {
			double total = p.imposto();
			System.out.println(p.getNome()+": $ " + String.format("%.2f", total));
			soma += total;
		}
		
		System.out.println();
		System.out.printf("Total de impostos: $ %.2f%n",soma);

		sc.close();
	}

}
