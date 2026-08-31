import java.io.*;
import java.util.*;
public class s
{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		String f=br.readLine();
		StringBuffer sb=new StringBuffer();
		int l=f.length();
		int n=l/2+1;
		int a[]=new int[n];
		int k=0;
		for(int i=0;i<l;i+=2)
		{
			int value=f.charAt(i)-48;
			a[k++]=value;

		}
		Arrays.sort(a);
		for(int i=0;i<n-1;i++)
		{
			sb.append(a[i]+"+");
		}
		sb.append(a[n-1]);
		pw.println(sb.toString());

	
	pw.flush();

	}
}
		