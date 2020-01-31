//Thomas Koehne 1/28/20

public class Decrypter {
	
	public static int[] decrypt(int[] plainText) {
		int[] decryptedInput = new int[4];
		decryptedInput = plainText;
		int tempInt;
		int tempInt2;
		
		//Switch first and third numbers
		tempInt = decryptedInput[0];
		tempInt2 = decryptedInput[2];
		decryptedInput[0] = tempInt2;
		decryptedInput[2] = tempInt;
		
		//Switch second and fourth numbers
		tempInt = decryptedInput[1];
		tempInt2 = decryptedInput[3];
		decryptedInput[1] = tempInt2;
		decryptedInput[3] = tempInt;
		
		//loop to reverse the encryption math
		for(int i = 0; i < decryptedInput.length; i++) {
			decryptedInput[i] = (decryptedInput[i] + 3) % 10;
		}
		
		return decryptedInput;
	}
	
}
