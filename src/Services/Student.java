package Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Student class creates each student with its name, grade, and quantity 
 * of signatures; gets their score and average and prints it
 */
public class Student {
	private String name;
	private String grade;
	private int signaturesNum;
	//Map for enrolled signatures
	private Map<Integer, Signature> signatures = new HashMap<Integer, Signature>(); 

	//Constructor
	public Student(String name, String grade, int signaturesNum) {
		this.name = name;
		this.grade = grade;
		this.signaturesNum = signaturesNum;
	}
	
	//Signatures setter
	public void setSignatures() {
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < signaturesNum; i++) {
			System.out.printf("Please enter the name of signature %d: \n", i+1);
		    String signatureName = scanner.nextLine(); 
		    System.out.printf("Please enter the score for %s: \n", signatureName);
		    float signatureScore = scanner.nextFloat(); 
		    scanner.nextLine();
		    signatures.put(i, new Signature(signatureName, signatureScore));
		}			
	}
	
	//Score average getter
	public float getScoreAverage(){
		float total = 0;
		for(int i = 0; i < signaturesNum; i++) {
			total += signatures.get(i).getScore();
		}
		return total/signaturesNum;
	}
	
	//Status getter
	public String getStatus() {
		String status = "Passed with good level";
		float average = getScoreAverage();
		if (average < 7.0) {
			status = "Failed";
		}
		else if (average >= 7 && average < 8) {
			status = "Passed with low level";
		}
		else if (average >= 8 && average < 9) {
			status = "Passed with good level";
		}
		else {
			status = "Passed with excellent level";
		}
		return status;
	}
	
	/*
	 * printAverage prints the report card, with student's name, grade, 
	 * signatures, their scores, score average and status
	 * Doesn't return anything
	 * Prints the report card
	 */
	public void printAverage() {
		System.out.println("----------------------------------------------------------");
		System.out.printf("Student name: %s \t Grade: %s\n", name, grade);
		System.out.println("----------------------------------------------------------");
		//Map to Stream to print each signature with it score
		signatures.entrySet()
			.stream()	
			.forEach((signature) ->{
				System.out.printf("\tSignature: %s \t\t Score: %.1f\n", signature.getValue().getName(), signature.getValue().getScore());
			});
		System.out.println("----------------------------------------------------------");
		System.out.printf("Final average: %.2f \t\t Status: %s\n", getScoreAverage(), getStatus());
	}
}
