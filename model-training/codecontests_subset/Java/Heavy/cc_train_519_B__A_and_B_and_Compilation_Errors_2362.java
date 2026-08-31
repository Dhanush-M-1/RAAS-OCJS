import java.util.*;
public class A_and_B_compilation_Errors

{
	public  static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int j;
		int[] b=new int[a];
		int[] c=new int[a-1];
		int[] d=new int[a-2];
		for(int i=0;i<a;i++)
		{
			b[i]=s.nextInt();
		}
		Arrays.sort(b);
		for(int i=0;i<a-1;i++)
		{
			c[i]=s.nextInt();
		}
		Arrays.sort(c);
		for(int i=0;i<a-2;i++)
		{
			d[i]=s.nextInt();
		}
		Arrays.sort(d);
		for(j=0;j<a-1;j++)
		{
			if(b[j]!=c[j])
			{
				break;
			}
		}
		System.out.println(b[j]);
		for(j=0;j<a-2;j++)
		{
			if(c[j]!=d[j])
			{
				break;
			}
		}
		System.out.println(c[j]);
	}
	
}
