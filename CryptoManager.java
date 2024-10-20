/*
 * Class: CMSC203 
 * Instructor: Dr. Kuijt
 * Description: A class that encodes and decodes plain text utilizing the Caesar and Bellaso ciphrs.
 * Due: 10/06/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: RAUNAK MAHESHWARI
*/
public class CryptoManager {

	public static boolean isStringInBounds(String plainText) {
		char c;
		int asciiVal;
		int lowerRange = 32, upperRange = 95;
		for (int i = 0; i < plainText.length(); i++) {
			c = plainText.charAt(i);
			asciiVal = (int) c;
			if (asciiVal < lowerRange || asciiVal > upperRange) {
				return false;
			}
		}
		
		return true;
	}
	
	public static String caesarEncryption(String plainText, int key) {
		int lowerRange = 32, upperRange = 95, asciiVal;
		char c;
		String encryptedStr = "";
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}
	
		if (key > upperRange) {
			key %= 64;
		}
		
		for (int i = 0; i < plainText.length(); i++) {
			c = plainText.charAt(i);
			asciiVal = (int) c;
			asciiVal += key;
			if (asciiVal > upperRange) {
				asciiVal %= 64;
			}
			encryptedStr += String.valueOf(Character.toChars(asciiVal));
			
		}
		
		
		return encryptedStr;
	}
	
	public static String caesarDecryption(String encryptedText, int key) {
		int lowerRange = 32, upperRange = 95, asciiVal;
		char c;
		String decryptedStr = "";
		if (key > upperRange) {
			key %= 64;
		}
		
		for (int i = 0; i < encryptedText.length(); i++) {
			c = encryptedText.charAt(i);
			asciiVal = (int) c;
			
			asciiVal -= key;
			while (asciiVal < lowerRange) {
				asciiVal += 64;
			}
			
			decryptedStr += String.valueOf(Character.toChars(asciiVal));
		}
		
		return decryptedStr;
	}
	
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		String encryptedStr = "";
		String updatedBellasoStr = bellasoStr;
		char currentChar, bellasoChar;
		int lowerRange = 32, upperRange = 95;
		int counter = 0;
		int necessaryLen;
		int index = 0;
		int offset;
		int currentCharAscii, bellasoCharAscii;
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}
		if (bellasoStr.length() < plainText.length()) {
			necessaryLen = plainText.length() - bellasoStr.length();
			while(counter < necessaryLen) {
				if (index == bellasoStr.length()) {
					index = 0;
				}
				updatedBellasoStr += bellasoStr.charAt(index);
				counter += 1;
				index += 1;
			}
			
		}
		for (int i = 0; i < plainText.length(); i++) {
			currentChar = plainText.charAt(i);
			currentCharAscii = (int) currentChar;
			bellasoChar = updatedBellasoStr.charAt(i);
			bellasoCharAscii = (int) bellasoChar;
			offset = bellasoCharAscii + currentCharAscii;
			while (offset > upperRange) {
				offset -= (upperRange - lowerRange + 1);
			}
			encryptedStr += String.valueOf(Character.toChars(offset));
		}
		
		return encryptedStr;
		
	}
	
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decryptedStr = "";
		String updatedBellasoStr = bellasoStr;
		char currentChar, bellasoChar;
		int lowerRange = 32, upperRange = 95;
		int counter = 0;
		int necessaryLen;
		int index = 0;
		int offset;
		int currentCharAscii, bellasoCharAscii;
		if (bellasoStr.length() < encryptedText.length()) {
			necessaryLen = encryptedText.length() - bellasoStr.length();
			while(counter < necessaryLen) {
				if (index == bellasoStr.length()) {
					index = 0;
				}
				updatedBellasoStr += bellasoStr.charAt(index);
				counter += 1;
				index += 1;
			}
			
		}
		for (int i = 0; i < encryptedText.length(); i++) {
			currentChar = encryptedText.charAt(i);
			currentCharAscii = (int) currentChar;
			bellasoChar = updatedBellasoStr.charAt(i);
			bellasoCharAscii = (int) bellasoChar;
			offset = currentCharAscii - bellasoCharAscii;
			while (offset < lowerRange) {
				offset += (upperRange - lowerRange + 1);
			}
			decryptedStr += String.valueOf(Character.toChars(offset));
		}
		
		return decryptedStr;
	}
}
