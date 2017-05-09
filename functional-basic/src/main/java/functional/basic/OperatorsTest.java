package functional.basic;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Operator is a special case of function. Is used when all
 * type parameters are the same.
 * 
 * @author adrian.cosma
 *
 */
public class OperatorsTest {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		System.out.println(c.computeUnary(10, c.toPower2));
		System.out.println(c.computeUnary(10, c.toPower3));
		
		System.out.println();
		
		System.out.println(c.computeBinary(10, 20, c.add));
		System.out.println(c.computeBinary(10, 20, c.substract));
		System.out.println(c.computeBinary(10, 20, c.multiply));
		System.out.println(c.computeBinary(10, 20, c.divide));
	}
}

class Calculator {
	public UnaryOperator<Double> toPower2 = x -> Math.pow(x, 2);
	public UnaryOperator<Double> toPower3 = x -> Math.pow(x, 3);
	public UnaryOperator<Double> sqrt = x -> Math.sqrt(x);
	
	public BinaryOperator<Double> add = (a, b) -> a + b;
	public BinaryOperator<Double> substract = (a, b) -> a - b;
	public BinaryOperator<Double> multiply = (a, b) -> a * b;
	public BinaryOperator<Double> divide = (a, b) -> a / b;
	
	public Double computeUnary(double x, UnaryOperator<Double> operator) {
		return operator.apply(x);
	}
	
	public Double computeBinary(double x, double y, BinaryOperator<Double> operator) {
		return operator.apply(x, y);
	}
}
