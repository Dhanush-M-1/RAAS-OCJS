import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String l = s.nextLine();
		int n=0;

		StringTokenizer st = new StringTokenizer(l);
		PrintWriter pw = new PrintWriter(System.out);
		char[] ops = new char[(st.countTokens() -1)/2];
		ops[0]='+';
		int neg=0;
		for(int i=1;i<ops.length;i++)
		{
			st.nextToken();
			ops[i]=st.nextToken().charAt(0);
			if(ops[i]=='-') neg++;
		}	
		st.nextToken();
		st.nextToken();
		n=Integer.parseInt(st.nextToken());
		int pos = ops.length-neg;
		if(n<= pos*n - neg && n>= pos-neg*n)
		{
			pw.println("Possible");
			int cur = pos*n -neg-n;
				int temp = n - cur;
				cur=0;
				if(temp<=0) 
				{
					cur = 1-temp;
					temp=1;
				}
				pw.print(temp);
			for(int i=1;i<ops.length;i++)
			{
				if(ops[i]=='+'){
					temp = n - cur;
					cur=0;
					if(temp<=0) 
					{
						cur = 1-temp;
						temp=1;
					}
					pw.print(" + " + temp);
				}
				else
				{
					temp = 1+cur;
					cur=0;
					if(temp>n)
					{
						cur= temp-n;
						temp=n;
					}
					pw.print(" - " + temp);
				}
				
			}
			pw.println( " = "+n);
		}
		else pw.println("Impossible");
		pw.close();
	}
}