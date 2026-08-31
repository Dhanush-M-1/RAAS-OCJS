import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Scanner reader = new Scanner(System.in)) {

			int cases = reader.nextInt();
			for (int num = 0; num < cases; num++) {
				long number = reader.nextLong();
				long number2 = number;
				long number3 = number;
				
				
				int moves = 0;
				int twos = 0;
				int threes = 0;
				while(number2 % 2 == 0 )
				{	
					twos++; 
					number2 /= 2;
				}
				while(number3 % 3 == 0 )
				{	
					threes++; 
					number3 /= 3;
				}
			//	System.out.println("Number:" + number);
			//	System.out.println( twos + " " + threes) ;
				if(number == 1)
				{
					System.out.println("0");
					continue;
				}
				else if(threes < twos || Math.pow(3, threes) * Math.pow(2, twos) != number)
				{
					System.out.println("-1");
					continue;
				}
				else
				{
					System.out.println(threes + threes - twos);
				}

//				System.out.println("Number:" + number);
//				for (int i = 0; i < 20; i++) {
//					number *= 2;	
//					moves++;
//					
//					 if (Math.log(number)/Math.log(6) - (long)(Math.log(number)/Math.log(6)) < .00000001)
//					 {
//						 System.out.println(Math.log(number)/Math.log(6) + moves );
//					 }
//					
//				}
				
				
				
			}


		}

	}
	
	
}