//Thomas Koehne 1/28/20

import java.util.Scanner;

public class Application {

	static Scanner in = new Scanner(System.in);
	//Number of Digits to decrypt/encrypt
	public static int INT_LENGTH = 4;
	
	public static void main(String[] args) {
		
		int choice = 0;
		int[] userInput = new int[INT_LENGTH];
		
		//while loop to run application
		while (choice != 3) {
			
			//Take in request to encrypt/decrypt 
			choice = getUserChoice();
			
			//Ask for number to process 
			if(choice != 3 ) {
				userInput = getUserInput();
			}
			
			//process request and pass user input to right method for encryption/decryption
			switch (choice){
			case 1: {
				encryptUserInput(userInput);
				break;
			}
			case 2: {
				decryptUserInput(userInput);
				break;
			}
			case 3: {
				//Display exit message before leaving while loop
				System.out.println("\nExiting Program");
			}
			
			}
		}
		
		//Close scanner
		in.close();

	}
	
	//get 4 digit integer from user to encrypt/decrypt
	 static int[] getUserInput() {
		int[] userInput = new int[INT_LENGTH];
		System.out.print("\nEnter a " + INT_LENGTH + "  Digit Number to Process: ");
		String userInputRaw = in.next();
		
		//take string from input and convert to int array
		for (int i = 0; i < userInput.length; i++) {
			userInput[i] = userInputRaw.charAt(i) - '0';
		}

		//return integer as array
		return userInput;
	}
	
	 //Get user choice for what they want to do with the program
	static int getUserChoice() {
		int userChoice = 0;
		
		//While loop to ensure valid input for user choice
		while (userChoice != 1 && userChoice != 2 && userChoice != 3){
			System.out.println("What would you like to do:");
			System.out.println("1. Encrypt Number");
			System.out.println("2. Decrypt Number");
			System.out.println("3. Exit Program");
			System.out.print("(Enter 1 - 3): ");
			userChoice = in.nextInt();
			
			//if the user choice is invalid, repeat and ask again 
			if (userChoice != 1 && userChoice != 2 && userChoice != 3) {
				System.out.println("\nNumber must be 1 - 3!\n");
			}
		}
		return userChoice;
	}
	
	//Encrypt user input and display results
	static void encryptUserInput(int[] input) {
		int[] userInputEncrypted = new int[INT_LENGTH];
		
		//Pass original array to encrypter method 
		//get back encrypted array
		userInputEncrypted = Encrypter.encrypt(input);
		
		//output results
		System.out.print("\nEncrypted number: " );
		for (int i = 0; i < userInputEncrypted.length; i++) {
			System.out.print(userInputEncrypted[i]);
		}
		System.out.println("\n");
	}

	//Decrypt user input and display result
	static void decryptUserInput(int[] input) {
		int[] userInputDecrypted = new int[INT_LENGTH];
				
		//Pass original array to Decrypter method
		//get back decrypted array
		userInputDecrypted = Decrypter.decrypt(input);
		
		//output results
		System.out.print("\nDecrypted number: " );
		for (int i = 0; i < userInputDecrypted.length; i++) {
			System.out.print(userInputDecrypted[i]);
		}
		System.out.println("\n");
	}
}
