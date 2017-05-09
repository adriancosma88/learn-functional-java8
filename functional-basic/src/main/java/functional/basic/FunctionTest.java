package functional.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * A Function is responsible for turning one parameter into a value of a potentially different type.
 * 
 * @author adrian.cosma
 *
 */
public class FunctionTest {
	public static void main(String[] args) {
		Employee gigel = new Employee("Ionescu Gigel",
				7, 4000, 5.0);		
		SalaryCalculator sc = new SalaryCalculator();
		
		sc.displaySalary(gigel, SalaryCalculator.REGULAR_TAX, salaryWithNoBonus);
		sc.displaySalary(gigel, SalaryCalculator.REGULAR_TAX, salaryWithNoBonus2);
		sc.displaySalary(gigel, SalaryCalculator.REGULAR_TAX, salaryWithPerformanceBonus);
	
		System.out.println();
		
		//loop to display all algorithms
		for (Function<Employee, Double>function : salaryAlgorithms) {
			new SalaryCalculator().displaySalary(gigel, SalaryCalculator.REGULAR_TAX, function);
		}
	}
	
	//no bonus
	static Function<Employee, Double> salaryWithNoBonus = emp -> emp.getBaseSalary();
	
	//no bonus with direct method reference
	static Function<Employee, Double> salaryWithNoBonus2 = Employee::getBaseSalary;
	
	//with performance bonus
	static Function<Employee, Double> salaryWithPerformanceBonus = 
			 emp -> emp.getBaseSalary() + emp.getPerformanceBonus();
			 
	//with year and performance bonus
	static Function<Employee, Double> salaryWithYearAndPerformanceBonus = 
			emp -> {
				double experienceBonusPercentage = 
						(emp.getYearsInCompany() - Employee.BONUS_YEAR) * Employee.BONUS_PERCENTAGE_PER_YEAR;
				double experienceBonus = emp.getBaseSalary() * experienceBonusPercentage /100;
				
				return emp.getBaseSalary() + experienceBonus + emp.getPerformanceBonus();
			};
			 
	//create algorithms list
	static List<Function<Employee, Double>> salaryAlgorithms = 
			Arrays.asList(salaryWithNoBonus, salaryWithNoBonus2, 
					salaryWithPerformanceBonus, salaryWithYearAndPerformanceBonus);
}

class SalaryCalculator {
	public static final double REGULAR_TAX = 31.5;
	public static final double SPECIAL_TAX = 16;
	
	public void displaySalary(Employee e, double tax, 
			Function<Employee, Double> salaryCalculator) {
		
		double salary = substractTax(salaryCalculator.apply(e), tax);		
		System.out.println("The monthly salary for " + e.getName() 
				+ " is " + salary);
	}

	private double substractTax(Double salary, double tax) {
		return salary - tax * salary / 100;
	}
}

class Employee {
	public static final int BONUS_YEAR = 3;
	public static final int BONUS_PERCENTAGE_PER_YEAR = 1;
	
	private String name;
	private int yearsInCompany;
	private double baseSalary;
	private double performanceBonus;
	
	public Employee(String name, int yearsInCompany, double baseSalary, double performanceBonus) {
		this.name = name;
		this.yearsInCompany = yearsInCompany;
		this.baseSalary = baseSalary;
		this.performanceBonus = performanceBonus;
	}

	public String getName() {
		return name;
	}

	public int getYearsInCompany() {
		return yearsInCompany;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double getPerformanceBonus() {
		return baseSalary * performanceBonus / 100;
	}
}



