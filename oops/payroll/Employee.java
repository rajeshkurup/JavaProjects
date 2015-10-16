package payroll;

public class Employee {

	private long id;

	private String name;

	private double salary;

	private double allowance;

	public Employee() {
		this.id = 0;
		this.name = "";
		this.salary = 0.0;
		this.allowance = 0.0;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAllowance() {
		return this.allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double netSalary() {
		return this.salary + this.salary * this.allowance;
	}
}