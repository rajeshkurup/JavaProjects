import java.io.*;
import payroll.Employee;

public class Payroll {

	public static void main(String[] args) {
		Employee employee = new Employee();
		Console console = System.console();

		System.out.println("Enter Employee Id: ");
		employee.setId(Long.parseLong(console.readLine()));

		System.out.println("Enter Employee Name: ");
		employee.setName(console.readLine());

		System.out.println("Enter Employee Salary: ");
		employee.setSalary(Double.parseDouble(console.readLine()));

		System.out.println("Enter Employee Allowance: ");
		employee.setAllowance(Double.parseDouble(console.readLine()));

		System.out.println("Enter Employee Net Salary: " + String.format("%.2f", employee.netSalary()));
	}
}