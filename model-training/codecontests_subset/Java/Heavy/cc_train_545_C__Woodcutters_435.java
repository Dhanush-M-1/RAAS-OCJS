import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Woodcutters301 {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int [] x = new int[n];
		int [] h = new int[n];
		
		for (int i = 0; i<n; ++i)
		{
			String [] data = in.readLine().split(" ");
			x[i] = Integer.parseInt(data[0]);
			h[i] = Integer.parseInt(data[1]);
		}
		
		if (n == 1)
		{
			System.out.println(1);
			System.exit(0);
		}
		
		int extremoDerecho = x[0];
		int c = 2;
		for(int i = 1; i<n-1; ++i)
		{
			if(extremoDerecho<x[i]-h[i])
			{
				++c;
				extremoDerecho = x[i];
			}
			else
			{
				if(x[i]+h[i]<x[i+1])
				{
					++c;
					extremoDerecho = x[i] + h[i];
				}
				else
				{
					extremoDerecho = x[i];
				}
			}
		}
		System.out.println(c);
		
	}

}
