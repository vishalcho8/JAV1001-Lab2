/*
  Name/Autor: Vishal Upendra Chavda
  Student ID: A00242303
  Course:     Mobile Application Development (MAPD)
  Created on: 01/10/2021 (DD/MM/YYYY)
  Description: This program will perform following functions/operations.
    A. Accepts a String (the String to encrypt) from user,
        a shift value from user, encrypt the user string through Caesar cipher method and returns the new String.
        Simillary, it will decrypt the result and produce the actual string entered by user.
    B. Accepts an array of numeric values from user and produces the average of all values
    C. Accepts a numeric search value, and determines if the array created at point B contains the value
    D. Reverses an array craeted at point B.
*/

import java.util.*;  // Import java.util package

class ArrayTools {
    public static void main(String[] args) {

		//Declaring required variables
		int inEncyptLevel, inSearchNum;
		String inEncrypt;
		int[] inTestArray = new int[]{12,16,77,98,23,22,43,56};

		Scanner keyboard = new Scanner(System.in);				// Create a Scanner object

		System.out.print("Enter a string to encrypt: ");
		inEncrypt = keyboard.next();                      		//Store the user entered string value in the variable

		System.out.print("Enter a value to encrypt with: ");
		inEncyptLevel = keyboard.nextInt();                  	//Store the user entered numeric value in the variable

		/* Calling method doEncrypt -  for encryption*/
		String outEncrypt = doEncrypt(inEncrypt, inEncyptLevel);
		System.out.println("The encrypted string is: "+ outEncrypt);

		/* Calling method doDecrypt -  for decryption*/
		String outDecrpyt = doDecrypt(outEncrypt, inEncyptLevel);
		System.out.println("Decrypting "+ outEncrypt + " with " + (-1 * inEncyptLevel) + ": " + outDecrpyt);

		System.out.println();                         			//This will insert a blank line in console.
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

	/* Method doEncrypt(): This method will encrypt the user entered string using Caesar cipher encyption method. */
	public static String doEncrypt(String inEncrypt, int inEncyptLevel){
		String retEncrypt = new String();
		int position,temp;
		for (int i = 0; i < inEncrypt.length(); i++)
		{
			if(Character.isUpperCase(inEncrypt.charAt(i)))
			{
				position = inEncrypt.charAt(i) - 'A' + 0; 		//This will get the position of the corresponding alphabet
				temp = (position + inEncyptLevel) % 26;
				retEncrypt += String.valueOf((char)(temp + 65));
			}
			else
			{
				position = inEncrypt.charAt(i) - 'a' + 0; 		//This will get the position of the corresponding alphabet
				temp = (position + inEncyptLevel) % 26;
				retEncrypt += String.valueOf((char)(temp + 97));
			}
		}
		return retEncrypt;
	}

	/* Method doDecrypt(): This methid will decrypt the result generated through doEncrypt method using Caesar cipher decyption method.  */
	public static String doDecrypt(String inEncrypt, int inEncyptLevel){
		String retDecrypt = new String();
		int position,temp;
		for (int i = 0; i < inEncrypt.length(); i++)
		{
			if(Character.isUpperCase(inEncrypt.charAt(i)))
			{
				position = inEncrypt.charAt(i) - 'A' + 0; 		//This will get the position of the corresponding alphabet
				temp = (position - inEncyptLevel) % 26;
                /* Following if statement will protect the decrypt sting from getting unknown/unsupported characters and
                    make sure output remains between a to z or A to Z.
                */
				if(temp < 0)
				{
					temp += 26;
				}
				retDecrypt += String.valueOf((char)(temp + 65));
			}
			else
			{
				position = inEncrypt.charAt(i) - 'a' + 0; 		//This will get the position of the corresponding alphabet
				temp = (position - inEncyptLevel) % 26;
                /* Following if statement will protect the decrypt sting from getting unknown/unsupported characters and
                    make sure output remains between a to z or A to Z.
                */
				if(temp < 0)
				{
					temp += 26;
				}
				retDecrypt += String.valueOf((char)(temp + 97));
			}
		}
		return retDecrypt;
	}

	/* Method calcAvg(): This method will calculate the average of the values present in the given array. */
	public static float calcAvg(int [] inTestArray){
		float sum = 0f;
		for (int i = 0; i < inTestArray.length;i++){
			sum = sum + inTestArray[i];
		}
		return  sum / inTestArray.length;
	}

	/* Method findInArray(): This method will check if the user entered inEncyptLevel is present in the given array */
	public static boolean findInArray(int [] inTestArray, int inEncyptLevel){
		for (int i = 0; i < inTestArray.length;i++){
			if (inTestArray[i] == inEncyptLevel)
			{
				return true;
			}
		}
		return false;
	}

	/* Method reverseArray(): This method will reverse the given input array */
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
