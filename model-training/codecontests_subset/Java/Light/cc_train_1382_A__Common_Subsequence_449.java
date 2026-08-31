import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++)
		{
			int len1 = sc.nextInt();
			int len2 = sc.nextInt();
			int sub = -1;
			ArrayList<Integer> arr1 = new ArrayList<>();
			for (int j = 0; j < len1; j++)
			{
				arr1.add(sc.nextInt());
			}
			for (int j = 0; j < len2; j++)
			{
				int temp = sc.nextInt();;
				if (arr1.contains(temp))
				{
					sub = temp;
					
				}
			}
			if (sub >= 0)
			{
				pw.println("YES");
				pw.println("1 " + sub);
			}
			else 
			{
				pw.println("NO");
			}
		}
		
		pw.close();
	}
	
	
}
