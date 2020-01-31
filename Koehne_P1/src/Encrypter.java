//Thomas Koehne 1/28/20

public class Encrypter {
		
	public static int[] encrypt(int[] plainText) {
		int[] encryptedInput = new int[4];
		encryptedInput = plainText;
		int tempInt;
		int tempInt2;
		
		//Encryption math
		for(int i = 0; i < encryptedInput.length; i++) {
			encryptedInput[i] = (encryptedInput[i] + 7) % 10;
		}
		
		//Switch first and third numbers
		tempInt = encryptedInput[0];
		tempInt2 = encryptedInput[2];
		encryptedInput[0] = tempInt2;
		encryptedInput[2] = tempInt;
		
		//Switch second and fourth numbers
		tempInt = encryptedInput[1];
		tempInt2 = encryptedInput[3];
		encryptedInput[1] = tempInt2;
		encryptedInput[3] = tempInt;
		
		return encryptedInput;
	}
	
}
