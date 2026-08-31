import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
final public class DCompiler
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		String inp[]=br.readLine().split(" ");
		int sum1=0,sum2=0,sum3=0;
		for(int i=0;i<t;i++)
			sum1+=(Integer.parseInt(inp[i]));
		inp=br.readLine().split(" ");
		for(int i=0;i<t-1;i++)
			sum2+=(Integer.parseInt(inp[i]));
		inp=br.readLine().split(" ");
		for(int i=0;i<t-2;i++)
			sum3+=(Integer.parseInt(inp[i]));
		System.out.println(sum1-sum2);
		System.out.println(sum2-sum3);
		
			
	}
}