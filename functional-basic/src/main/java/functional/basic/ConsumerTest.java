package functional.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 
 * Consumer. Eclipse Templates. Enclosing Class. How to use a lambda expression.
 * 
 * Consumer is used when you want to do something with a parameter,
 * but you don't want to return anything.
 * 
 * @author adrian.cosma
 *
 */
public class ConsumerTest {
	public static void main(String[] args) {
		List<Integer> integersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		//Java 7 style
		for (Integer integer : integersList) {
			System.out.println(integer);
		}
		
		//declared inside class
		integersList.forEach(new SimpleDisplay<Integer>());
		integersList.forEach(new SimpleDisplay<>());
		integersList.forEach(new DisplayDouble());
		
		//declared in-line
		integersList.forEach(x -> System.out.println(x * 3));
		
		//declared in-line using method reference
		integersList.forEach(x -> displayTriple(x));
		
		//declared as an object
		integersList.forEach(displayTriple);
	}

	private static void displayTriple(Integer x) {
		System.out.println(x * 3);
	}
	
	private static Consumer<Integer> displayTriple = x -> System.out.println(x * 3);
}

class SimpleDisplay<X> implements Consumer<X> {
	public void accept(X x) {
		System.out.println(x);
	}
}

class DisplayDouble implements Consumer<Integer> {
	@Override
	public void accept(Integer x) {
		System.out.println(x.intValue() * 2);
	}
}