package Services;

/*
 * Interface to rewrite the different types of operations
 * for the calculator
 */
@FunctionalInterface
public interface CalculatorInterface {
	public float operation(int a, int b);
}