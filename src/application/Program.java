package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		Address address = new Address(email, phone);
		
		Department dept = new Department(departmentName, payDay, address);
		
		System.out.print("Quantos funcionarios tem o departamento? ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			System.out.printf("Dados do funcionario %d:\n", (i+1));
			System.out.print("Nome: ");
			sc.nextLine();	
			String employeeName = sc.nextLine();
			System.out.print("Salario: ");
			double employeeSalary = sc.nextDouble();
			
			Employee emp = new Employee(employeeName, employeeSalary);
			
			dept.addEmployee(emp);
		}
		
		showReport(dept);
		
		sc.close();

	}
	
	public static void showReport(Department dept) {
		
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.println("Departamento " + dept.getName() + " = R$ " + String.format("%.2f", dept.payroll()));
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionarios:");
		for (Employee emp : dept.getEmployees()) {
			System.out.println(emp.getName());
		}
		System.out.println("Para duvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}
	

}
