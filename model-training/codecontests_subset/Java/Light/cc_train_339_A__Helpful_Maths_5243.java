import java.util.Arrays;
import java.util.Scanner;
public class HelpfulMaths
{
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		String s=sc.next();
		if(s.length()==1)
			System.out.println(s);
		else
		{
			String v[]=s.split("\\+");
		/*	int a[]=new int a[v.length];
			for(int i=0;i<a.length;i++)
			{
				a[i]=Integer.parse
			}*/
			Arrays.sort(v);
			String z="";
			for(int i=0;i<v.length;i++)
			{
				z=z+v[i]+"+";
				
			}
			String a=z.substring(0,z.length()-1);
			System.out.println(a);
		}
	}
}