//Thomas Koehne 1/28/20

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		int choice = 0;
		int[] userInput = new int[4];
		
		//while loop to run application
		
		while (choice != 3) {
			
			//Take in request to encrypt/decrypt and initial input
			choice = getUserChoice();
			
			//Ask for number to process 
			if(choice != 3 ) {
				userInput = getUserInput();
			}
			
			//process request and pass number to right method
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
				System.out.println("Program is Exiting");
			}
			}
			//display correct output
		}

	}
	
	 static int[] getUserInput() {
		Scanner in = new Scanner(System.in);
		int[] userInput = new int[4];
		System.out.print("\nEnter a 4 Digit Number to Process: ");
		String userInputRaw = in.next();
		
		for (int i = 0; i < userInput.length; i++) {
			userInput[i] = userInputRaw.charAt(i) - '0';
		}

		return userInput;
	}
	
	static int getUserChoice() {
		Scanner input = new Scanner(System.in);
		int userChoice = 0;
		boolean validInput = false;
		
		while (validInput == false){
			System.out.println("What would you like to do:");
			System.out.println("1. Encrypt Number");
			System.out.println("2. Decrypt Number");
			System.out.println("3. Exit Program");
			System.out.print("(Enter 1 - 3): ");
			userChoice = input.nextInt();
			
			if ((userChoice == 1) || (userChoice == 2) || (userChoice == 3)) {
				validInput = true;
			}
			else {
				System.out.println("\nNumber must be 1 - 3!\n");
			}
		}
		return userChoice;
	}
	
	
	static void encryptUserInput(int[] input) {
		int[] userInputEncrypted = new int[4];
		
		//Pass array to encrypter
		userInputEncrypted = Encrypter.encrypt(input);
		
		//output results
		System.out.print("\nEncrypted number: " );
		for (int i = 0; i < userInputEncrypted.length; i++) {
			System.out.print(userInputEncrypted[i]);
		}
		System.out.println("\n");
	}

	static void decryptUserInput(int[] input) {
		int[] userInputDecrypted = new int[4];
				
		//Pass array to Decrypter
		userInputDecrypted = Decrypter.decrypt(input);
		
		//output results
		System.out.print("\nEncrypted number: " );
		for (int i = 0; i < userInputDecrypted.length; i++) {
			System.out.print(userInputDecrypted[i]);
		}
		System.out.println("\n");
	}
}
