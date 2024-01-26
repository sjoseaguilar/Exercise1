package Main;

import Services.Calculator;
import Services.Encoder;
import Services.Student;

import java.util.Scanner;

/*
 * BasicUtils class is the main class in which you can use
 * a basic calculator, an encoder/decoder and a student 
 * average calculator
 * Author: Sarahí José
 * Date: January 25th, 2024
 */
public class BasicUtils{
	
	public static void main(String[] args) {
		
		//Scanner object for future inputs
		Scanner scanner = new Scanner(System.in);
		
		//Print menu
		System.out.println("Select an option to continue:");
		System.out.println("	1.- Basic calculator");
		System.out.println("	2.- Encoder");
		System.out.println("	3.- Student average calculator");
		
	    System.out.print("Enter option: ");

	    //Save option selected input
	    int optionSelected = scanner.nextInt(); 
	    scanner.nextLine();
	    
	    //Depends on option selected it will have a dif behavior
	    switch(optionSelected) {
	    	case 1: 
	    		Calculator calc = new Calculator();
	    		calc.calculate();
	    		break;
	    		
	    	case 2:
	    		Encoder enc = new Encoder();
	    		enc.encodeDecode();
	    		break;
	    		
	    	case 3:
	    		System.out.println("Enter your name: ");
	    		String studentName = scanner.nextLine(); 
	    		System.out.println("Enter your grade: ");
	    		String studentGrade = scanner.nextLine();
	    		System.out.println("Enter the number of signatures to enroll: ");
	    		int signaturesNum = scanner.nextInt();
	    		scanner.nextLine();
	    		Student student = new Student(studentName, studentGrade, signaturesNum);
	    		student.setSignatures();
	    		student.printAverage();
	    		break;
	    		
	    	default:
	    		break;
	    }
	}
}
