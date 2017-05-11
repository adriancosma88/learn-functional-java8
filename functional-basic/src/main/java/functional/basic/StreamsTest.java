package functional.basic;

import java.util.Arrays;
import java.util.List;

public class StreamsTest {
	
	public static void main(String[] args) {
		List<Integer> integersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		integersList.stream()
			.filter(x -> x % 2 == 0)
			.filter(x -> x % 3 == 0)
			.map(x -> Double.valueOf(x))
			.forEach(x -> System.out.println(x));
	}
}
