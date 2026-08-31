import java.text.*;
import java.util.*;

public class CodeForces7 {

		public static void main(String [] args)
		{
			
			Scanner sc = new Scanner(System.in);
			
			int k = sc.nextInt();
			
			String ss = sc.next();
			int len = ss.length();
			char arr[] = new char[ss.length()];
			int sum[] = new int [ss.length()];
			
			int j = 0;
			for(int i = 0 ; ss.length() > 0;  j++)
			{
				arr[j] = ss.charAt(i);
				ss = ss.replaceAll(ss.substring(i, i+1), "");
				sum[j] = len - ss.length();
				
				len = ss.length();
			}
			
			for(int i = 0 ; i < j ; i++)
			{
				if(sum[i] % k != 0)
				{
					System.out.println(-1);
					return;
				}
			}
			
			for(int i = 0 ; i < k ; i++)
			{
				for(int l = 0 ; l < j ; l++)
				{
					for(int f = 0 ; f < sum[l] / k ; f++)
						System.out.print(arr[l]);
				}
			}
			
			
			
		}
	}




