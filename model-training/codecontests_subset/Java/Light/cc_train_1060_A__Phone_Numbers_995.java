import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		int eightNums = 0;
		int m = n/11;
		for(int i = 0; i<str.length() && eightNums < m; i++)
		{
			if(str.charAt(i) == '8')
			{
				eightNums++;
			}
		}
		System.out.println(eightNums);

			
		
	}



}
