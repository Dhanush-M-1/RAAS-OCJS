

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		String number=new String();
		Scanner scan= new Scanner(System.in);
		int numOfDigit=1;
		if (scan.hasNextInt())
		 numOfDigit=scan.nextInt();	
		
		if(scan.hasNext())
		number=scan.next();	
		int count=0;
		if(numOfDigit>=11)
		{
		for(int i=0;i<number.length();i++)
		{
			if(number.charAt(i)=='8')
				count++;
			if (count>=(numOfDigit/11))
				break;
		}
		}
			System.out.println(""+count);
			scan.close();
		
	}
}
