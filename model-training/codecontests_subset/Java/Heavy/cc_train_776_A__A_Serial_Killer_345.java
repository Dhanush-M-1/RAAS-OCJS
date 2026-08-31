import java.util.*;

public class SerialKiller
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		String in1=s.next();
		String in2=s.next();
		int n=s.nextInt();
		String[] killed=new String[n];
		String[] replaced=new String[n];
		for(int i=0;i<n;i++)
		{
			killed[i]=s.next();
			replaced[i]=s.next();
		}
		String[] out1=new String[n+1];
		String[] out2=new String[n+1];
		out1[0]=in1;
		out2[0]=in2;
		for(int i=1;i<=n;i++)
		{
			if(killed[i-1].equals(out1[i-1]))
			{
				out1[i]=replaced[i-1];
				out2[i]=out2[i-1];
			}
			else
			{
				out2[i]=replaced[i-1];
				out1[i]=out1[i-1];
			}
		}
		for(int i=0;i<n+1;i++)
		{
			System.out.println(out1[i]+" "+out2[i]);
		}
	}
}