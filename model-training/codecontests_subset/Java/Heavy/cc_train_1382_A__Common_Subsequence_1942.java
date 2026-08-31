import java.io.*;
import java.util.*;
public class CF658A 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String s=br.readLine();
			String st[]=s.split(" ");
			int n=Integer.parseInt(st[0]), m=Integer.parseInt(st[1]);
			s=br.readLine();
			String str[]=s.split(" ");
			HashSet<String> h=new HashSet<>();
			for(int x=0;x<n;x++)
				h.add(str[x]);
			s=br.readLine();
			String stri[]=s.split(" ");		
			int f=0;
			for(int x=0;x<stri.length;x++)
			{
				if(h.contains(stri[x]))
				{
					f=1;
					System.out.println("YES\n1 "+stri[x]);
					break;
				}
			}
			if(f==0)
				System.out.println("NO");
		}
	}
}