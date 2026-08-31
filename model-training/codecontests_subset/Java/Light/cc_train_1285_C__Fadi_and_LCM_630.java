import java.util.*;
import java.text.DecimalFormat;
import java.io.*;
public class FedorNewGame {
	
	public static long hcf(long a, long b)
	{
		if (b == 0) 
	        return a; 
	    return hcf(b, a % b); 
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long x=Long.parseLong(br.readLine());
		long a=1;
		long b=x;
		for (long i=2;i<Math.sqrt(x);i++)
		{
			if (x%i==0)
			{
				if (Math.max(i, x/i)<Math.max(a, b) && hcf(i,x/i)==1)
				{
					a=i;
					b=x/i;
				}
			}
		}
		System.out.println(a+" "+b);
	}
}
