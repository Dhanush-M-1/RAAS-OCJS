import java.util.*;
import java.io.*;
public class Games {
public static void main(String args[]) throws IOException
{
	BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
	int runs=Integer.parseInt(f.readLine());
	int[] home=new int[101];
	int[] guest=new int[101];
	for(int x=0;x<runs;x++)
	{
		StringTokenizer st=new StringTokenizer(f.readLine());
		home[Integer.parseInt(st.nextToken())-1]++;
		guest[Integer.parseInt(st.nextToken())-1]++;
	}
	int change=0;
	for(int x=0;x<100;x++)
	change+=home[x]*guest[x];
	System.out.println(change);
}
}
