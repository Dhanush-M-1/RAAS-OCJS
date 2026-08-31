import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args){ 
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintStream output = new PrintStream(System.out);
		String s[] = new String[2];
		try{s = input.readLine().split(" ");}	  
		catch(IOException e1){e1.printStackTrace();}			
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		s = new String[m+1];
		int k[] = new int[m+1];
		for(int i = 0 ; i < n ; i++)
		{
			try{s = input.readLine().split(" ");}	  
			catch(IOException e1){e1.printStackTrace();}
			for(int j = 1 ; j < s.length ; j++)
				k[Integer.parseInt(s[j])]++;

		}
			for(int j = 1 ; j <= m ; j++)
				if(k[j] == 0)
				{
					output.println("NO");
					System.exit(0);
				}
		output.println("YES");
	}
}
