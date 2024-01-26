package Services;
import java.util.Scanner;
import java.util.Base64;

/*
 * Encoder class encodes string to Base64 or decodes a Base64 string
 * to normal word
 */
public class Encoder {
	
	/*
	 * encoderMenu prints the menu with the available operations
	 * and scans the selected option
	 * return: (int) optionSelected
	 */
	public static int encoderMenu() {
		//Scanner object for future inputs
		Scanner scanner = new Scanner(System.in);
		
		//Print calculator menu
		System.out.println("\nSelect an option to continue:");
		System.out.println("	1.- Encode a String to Base64");
		System.out.println("	2.- Decode a String to Base64");
		
	    System.out.print("Enter option: ");

	    //Save option selected input
	    int optionSelected = scanner.nextInt(); 
	    return optionSelected;
	}
	
	/*
	 * encodeDecode does the lambda expression for the encoder interface
	 * and depends on the option selected it encodes or decodes 
	 * the resultant string
	 * Doesn't return anything
	 * Prints the resultant string
	 */
	public void encodeDecode () {
		//Scanner object for future inputs
		Scanner scanner = new Scanner(System.in);
				
		//lambda for encoder/decoder
		EncoderInterface encode = (String string) -> 			
			Base64.getEncoder().encodeToString(string.getBytes());
		EncoderInterface decode = (String string) -> {
			string.replaceAll("\n", "");
			byte[] decodedBytes = Base64.getDecoder().decode(string);
			return new String(decodedBytes);
			};
		
		int encOptionSelected = encoderMenu();
		
		//switch to select encode or decode
		switch(encOptionSelected) {
		case 1:
			System.out.println("Please enter the string to encode: ");
		    String stringToEncode = scanner.nextLine(); 
			System.out.printf("Encoded string is: %s ", encode.operation(stringToEncode));
			break;
			
		case 2:
			System.out.println("Please enter the string to encode: ");
		    String stringToDecode = scanner.nextLine(); 
			System.out.printf("Decoded string is: %s ", decode.operation(stringToDecode));
			break;
		default:
			break;
		}
	}
}
