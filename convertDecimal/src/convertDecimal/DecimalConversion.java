package convertDecimal;

import java.util.Scanner;

public class DecimalConversion {
	
	public static void main(String[] args) {
		double decimal;
		String octal="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter a decimal number :");
		decimal=sc.nextDouble(); // get the number entered as double
		long decimalP1=(int)decimal; // get the left side of the decimal number
		double decimalP2=decimal-(int)decimal; //get de right part of decimal number which represent the remainder
		if((decimalP1<8)&(decimalP2==0))
			System.out.println("the octal number is : "+decimalP1);
		else
		{
			
			while(decimalP1>=8)
			{
				octal=decimalP1%8+octal;
				decimalP1=decimalP1/8;
			}
			octal=decimalP1+octal;
			if(decimalP2!=0) {
			
				int i=0;
				octal+=".";
				while(i<8)
				{
					
					if(decimalP2*8-(int)(decimalP2*8)==0) 
					{
						octal+=(int)(decimalP2*8);
						break;
					}
					octal+=(int)(decimalP2*8);
					decimalP2=decimalP2*8-(int)(decimalP2*8);
					i++;
				}
			}
				System.out.println("the octal number is : "+octal);
				
				
		}
		
	}

}
