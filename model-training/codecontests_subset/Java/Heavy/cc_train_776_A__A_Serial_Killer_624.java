
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String s1[]=s.split(" ");
		String f=s1[0];
		String l=s1[1];
		String q,o,u;
		int n=Integer.parseInt(br.readLine());
		System.out.println(f+" "+l);
		for(int i=1;i<=n;i++)
		{
			q=br.readLine();
			String p[]=q.split(" ");
			o=p[1];
			u=p[0];
			//System.out.println(o+" "+u+" sdjgfusgfuisgui");
			if(u.equals(f))
			{
				System.out.println(o+" "+l);	
				f=o;
			}
			else if(u.equals(l))
			{
				System.out.println(o+" "+f);
				l=o;
			}
			else if(o.equals(f))
			{
				System.out.println(u+" "+l);
				f=u;
			}
			else if(o.equals(l))
			{
				System.out.println(f+" "+u);
				l=u;
			}
		}
		
	}
}
