//import java.lang.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); 
		int [] arr = new int[400005];
		
		while (t-- > 0)
		{
			int n = scanner.nextInt(); 
			for (int i = 1; i <= n; ++i)
				arr[i] = scanner.nextInt();
			
			int g = 0;
			int s = 0;
			int b = 0;
			
			int maxMedal = n / 2;
			if (1 + 2 + 2 <= maxMedal)
			{
				while (arr[maxMedal] == arr[maxMedal + 1] && maxMedal > 0)
					--maxMedal;
				
				int begin = 1;
				while (arr[begin] == arr[begin + 1] && begin <= maxMedal)
					++begin;
				g = begin;
				
				int i = 0;
				while (g >= s)
				{
					i = begin + 1;
					while (arr[i] == arr[i + 1] && i <= maxMedal)
						++i;
					begin = i;
					s = i - g;
				}
				b = maxMedal - g - s;
				if (g < b)
					System.out.println(g + " " + s + " " + b);
				else
					System.out.println("0 0 0");
			}
			else
				System.out.println("0 0 0");
		}
		
		scanner.close();
	} // end main
	
}
		 			 			 						 		  		 		  	