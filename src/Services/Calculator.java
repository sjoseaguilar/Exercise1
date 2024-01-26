package Services;
import java.util.Scanner;

/*
 * Calculator class process 4 basic operations
 * sum, subtract, multiply and divide
 */
public class Calculator{
	
	/*
	 * calculatorMenu prints the menu with the available operations
	 * and scans the selected option
	 * return: (int) optionSelected
	 */
	public static int calculatorMenu() {
		//Scanner object for future inputs
		Scanner scanner = new Scanner(System.in);
		
		//Print calculator menu
		System.out.println("\nSelect an option to continue:");
		System.out.println("	1.- Sum (a + b)");
		System.out.println("	2.- Substract (a - b)");
		System.out.println("	3.- Multiply (a x b)");
		System.out.println("	4.- Divide (a / b)");
		
	    System.out.print("Enter option: ");

	    //Save option selected input
	    int optionSelected = scanner.nextInt(); 
	    return optionSelected;
	}
	
	/*
	 * askValue asks for the a and b values for the operations
	 * return: (int) inputValue
	 */
	public static int askValue(char var) {
		//Scanner object for future inputs
		Scanner scanner = new Scanner(System.in);
				
		System.out.printf("Please enter the value for %c: ", var);
		
		//Save input
	    int input = scanner.nextInt(); 
	    return input;
	}
	
	/*
	 * calculate does the lambda expression for the calculator interface
	 * and depends on the option selected it calculates the result for 
	 * the operation
	 * Doesn't return anything
	 * Prints the result
	 */
	public void calculate () {
		//lambda for calculator
		CalculatorInterface sum = (int a,int b) -> (a+b);
		CalculatorInterface sub = (int a,int b) -> (a-b);
		CalculatorInterface mult = (int a,int b) -> (a*b);
		CalculatorInterface div = (int a,int b) -> {
			if(b == 0) {
				return 0; //there's no division by 0
			}
			else {
				return (float) a/b;
			}	
		};
		
		int calcOptionSelected = calculatorMenu();
		int a = askValue('a');
		int b = askValue('b');	
		
		//Switch to select the operation
		switch(calcOptionSelected) {
		case 1:
			System.out.printf("The result is: %.1f ", sum.operation(a, b));
			break;
			
		case 2:
			System.out.printf("The result is: %.1f ", sub.operation(a, b));
			break;
			
		case 3:
			System.out.printf("The result is: %.1f ", mult.operation(a, b));
			break;
			
		case 4:
			float result = div.operation(a, b);
			if(result == 0) {
				System.out.printf("Cannot divide by 0");
			}
			else {
				System.out.printf("The result is: %.1f ", result);
			}	
			break;
			
		default:
			break;
		}
	}
}
