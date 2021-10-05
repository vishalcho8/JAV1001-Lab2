/*
  Name/Autor: Vishal Upendra Chavda
  Student ID: A00242303
  Course:     Mobile Application Development (MAPD)
  Created on: 01/10/2021 (DD/MM/YYYY)
  Description: This program will perform following functions/operations.
    A. Accepts a String (the String to encrypt) from user,
        a shift value from user, encrypt the user string through Caesar cipher method and returns the new String.
        Simillary, it will decrypt the result and produce the actual string entered by user.
        Note: This may show the ? sign if values goes negative or when particular ascii character is not supported.
    B. Accepts an array of numeric values from user and produces the average of all values
    C. Accepts a numeric search value, and determines if the array created at point B contains the value
    D. Reverses an array craeted at point B.
    E. It will create a documentaion for each method if javadoc ArrayTools.Java command fired
*/

import java.util.*;  // Import java.util package

public class ArrayTools {
    public static void main(String[] args) {

		//Declaring required variables
		int inEncryptLevel, inSearchNum;
		String inEncrypt;
		int[] inTestArray = new int[]{12,16,77,98,23,22,43,56};

		Scanner keyboard = new Scanner(System.in);				// Create a Scanner object

		System.out.print("Enter a string to encrypt: ");
		inEncrypt = keyboard.nextLine();                      	//Store the user entered string value in the variable

		System.out.print("Enter a value to encrypt with: ");
		inEncryptLevel = keyboard.nextInt();                  	//Store the user entered numeric value in the variable

		/* Calling method doEncrypt -  for encryption*/
		String outEncrypt = doEncrypt(inEncrypt, inEncryptLevel);
		System.out.println("The encrypted string is: "+ outEncrypt);

		/* Calling method doDecrypt -  for decryption*/
		String outDecrpyt = doDecrypt(outEncrypt, inEncryptLevel);
		System.out.println("Decrypting "+ outEncrypt + " with " + (-1 * inEncryptLevel) + ": " + outDecrpyt);

		System.out.println();                         			//This will insert a blank line in console just so that output does not look messy.
		System.out.println("Testing methods with: "+ Arrays.toString(inTestArray));
		/* Calling method calcAvg -  Calculate average of teh array values */
		float outAvg = calcAvg(inTestArray);
		System.out.println("The average is: " + outAvg);

		System.out.println();                         			//This will insert a blank line in console.
		System.out.print("Enter a value to search for: ");
		inSearchNum = keyboard.nextInt();            			//Store the user entered numeric value in the variable

		/* Calling method findInArray -  check if the value present in an aaray */
		boolean isFound = findInArray(inTestArray, inSearchNum);
		if (isFound)
		{
			System.out.println("The array contains "+ inSearchNum );
		}
		else {
			System.out.println("The array does not contain "+ inSearchNum );
		}

		/* Calling method reverseArray -  reverse the passed array */
		int[] outRevArray = reverseArray(inTestArray);
		System.out.println();
		System.out.println("The array reversed is: "+ Arrays.toString(outRevArray));

	}

    /**
    * This method will encrypt the user entered string using Caesar cipher encyption method
    * @param    inEncrypt       String to be encrypted
    * @param    inEncryptLevel  Encryption level
    * @return                   The encrypted string
    */
	public static String doEncrypt(String inEncrypt, int inEncryptLevel){
		String retEncrypt = new String();
		int temp;
		for (int i = 0; i < inEncrypt.length(); i++)
		{
            temp = (int)inEncrypt.charAt(i) + inEncryptLevel;
            retEncrypt += String.valueOf((char)(temp));
		}
		return retEncrypt;
	}

    /**
    * This method will decrypt the result generated through doEncrypt method using Caesar cipher decyption method
    * @param    inDecrypt       String to be decrypted
    * @param    inDecryptLevel  Decryption level
    * @return                   The decrypted string
    */
	public static String doDecrypt(String inDecrypt, int inDecryptLevel){
		String retDecrypt = new String();
		int temp;
		for (int i = 0; i < inDecrypt.length(); i++)
		{
            temp = (int)inDecrypt.charAt(i) - inDecryptLevel;
            retDecrypt += String.valueOf((char)(temp));
		}
		return retDecrypt;
	}

    /**
    * This method will calculate the average of the values present in the given array
    * @param    inTestArray     Array of ineteger
    * @return                   The average of the array value
    */
	public static float calcAvg(int [] inTestArray){
		float sum = 0f;
		for (int i = 0; i < inTestArray.length;i++){
			sum = sum + inTestArray[i];
		}
		return  sum / inTestArray.length;
	}

    /**
    * This method will check if the user entered number is present in the given array
    * @param    inTestArray      Array of ineteger
    * @param    inSearchNum      Number to be searched in the given array
    * @return                    Boolean based on result
    */
	public static boolean findInArray(int [] inTestArray, int inSearchNum){
		for (int i = 0; i < inTestArray.length;i++){
			if (inTestArray[i] == inSearchNum)
			{
				return true;
			}
		}
		return false;
	}

    /**
    * This method will reverse the given array
    * @param    inTestArray      Array of ineteger
    * @return                    Reversed integer array
    */
	public static int[] reverseArray(int [] inTestArray){
		int[] retRevArray = new int[inTestArray.length];
		int j = 0;
		for (int i = inTestArray.length-1; i >= 0;i--){
			retRevArray[j] = inTestArray[i];
			j++;
		}
		return retRevArray;
	}

}
