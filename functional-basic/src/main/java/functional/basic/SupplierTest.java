package functional.basic;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * 
 * Supplier is used when you want to generate values without taking any input.
 * 
 * @author adrian.cosma
 *
 */

public class SupplierTest {
	public static void main(String[] args) {
		displayDayOfWeek(getTodayDate());
		displayDayOfWeek(getYesterdayDate());
		
		displayDayOfWeek(() -> getTodayDate());
		displayDayOfWeek(() -> getYesterdayDate());
	}
	
	private static void displayDayOfWeek(LocalDate date) {		
		System.out.println(date.minusDays(1).getDayOfWeek());
	}
	
	private static void displayDayOfWeek(Supplier<LocalDate> dateSupplier){
		System.out.println(dateSupplier.get());
	}
	
	private static LocalDate getTodayDate() {
		return LocalDate.now();
	}
	
	private static LocalDate getYesterdayDate() {
		return LocalDate.now().minusDays(1);
	}	
}
