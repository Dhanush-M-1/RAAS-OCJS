import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Combo
{
	public static void main (String[] args) throws Exception
	{
		// your code goes here
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bu.readLine());
		StringBuilder sb=new StringBuilder();
		while(t-->0)
		{
			String s[]=bu.readLine().split(" ");
			int i,n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
			String st=bu.readLine();
			s=bu.readLine().split(" ");
			int mi[]=new int[m];
			for(i=0;i<m;i++)
			mi[i]=Integer.parseInt(s[i]);
			Arrays.sort(mi);
			long c[]=new long[26],pos[]=new long[n];
			for(i=0;i<st.length();i++)
			c[st.charAt(i)-97]++;
			
			int j,last=0;
			for(i=0;i<m;i++)
			{
				for(j=last;j<mi[i];j++)
				pos[j]=(m-i);
				last=j;
			}
			for(i=0;i<n;i++)
			c[st.charAt(i)-97]+=pos[i];
			
			for(i=0;i<26;i++)
			sb.append(c[i]+" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}