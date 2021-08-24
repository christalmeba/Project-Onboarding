package coding_challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CreditCard {
	
	
	/**
	 * 
	 * @param CardNumber
	 * @return
	 * 
	 *  this method  takes a number as an argument and returns true if the number 
	 *  is a valid credit card number
	 */
	public static boolean validateCardNumber(long CardNumber) {
		String myCardNumber=""+CardNumber;
		boolean isAValideCardNumber=false; // by default we suppose that the numbers provide by user is not a valid card number
		
		if(myCardNumber.length()>=14 && myCardNumber.length()<=19) 
		{
			
			List<Integer> arrayOfDigit=new ArrayList<>(); //this array will contain digits of card number
			
			// fill out the arrayOfDigit
			for(String digit:myCardNumber.split("")) 
			{
					arrayOfDigit.add(Integer.parseInt(digit)); // an Exception can happen in this expression
			}
			
			int checkDigit=arrayOfDigit.get(arrayOfDigit.size()-1); //last digit of myCardNumber is check Digit
			
			// reverse all digits in the arrayOfDigit except the last digit
			List<Integer> arrayOfDigitReverse=new ArrayList<>();
			for(int i=arrayOfDigit.size()-2;i>=0;i--)
			{
				arrayOfDigitReverse.add(arrayOfDigit.get(i));
				
			}
			// add all digits  
			/**
			 * Double the value of each digit in odd-numbered positions. 
			 * If the doubled value has more than 1 digit, add the digits together 
			 */
			int sumOfDigit=0;
			
			for (int i=0;i<arrayOfDigitReverse.size();i++) {
				int digit=arrayOfDigitReverse.get(i);
				
				if((i+1)%2!=0) {//i+1 because i start with 0
					
					if (digit*2>=10) //check if the double of digit contain two digits
					{
						digit=(digit*2)%10+(digit*2)/10;// add two digits to get one digit
						
					}
					else
						digit=digit*2;
					
				}
				
				sumOfDigit+=digit;
				
			}
		
			//getting the last digit of the sumOfDigit
			
			int lastDigit=Integer.parseInt((""+sumOfDigit).split("")[(""+sumOfDigit).length()-1]);
			
			//check if the Subtraction of last digit of the sum from 10  is equal to the check digit 
			if(10-lastDigit==checkDigit)
				isAValideCardNumber=true;
			
		}
		
		return isAValideCardNumber;
	}
	public static void main(String[] args) {
		System.out.println("Enter a number");
		Scanner myscan=new Scanner(System.in);
		long cardNum=0;
		try {
			 cardNum=myscan.nextLong();
		}catch(Exception e)
		{
			System.out.println("Wrong number");
		}
		
		System.out.println(validateCardNumber(cardNum));
	}

}
