
import java.util.Scanner;
public class Main {

	public static void main (String [] args) {
		int count = 0;
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()) {
			if(isPrime(in.nextInt())) {
				count++;
			}
		}
		
		System.out.println(count);
	}
		public static boolean isPrime(int i) {
			
			
			if(i == 2 || i == 3) {
				return true;
			}
			
			else if (i % 2 == 0 || i % 3 == 0) {
				return false;
			}
			
			
		
			else {
			
				for(int j = 5; j * j <= i; j += 6) {
					
					if((i % j == 0) || (i % (j + 2) == 0)) {
						return false;
					
					}
				}
				
				return true;
						
						
				}
			
		
			}
		}
		
		
		
		

	
	



