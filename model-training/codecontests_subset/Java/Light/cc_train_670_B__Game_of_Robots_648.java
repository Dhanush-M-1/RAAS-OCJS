import java.util.*;
public class m1 {
public static void main(String ra[])
{
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int k=s.nextInt();
	int a[]=new int[n];
	for(int i=0;i<n;i++)
	{
		a[i]=s.nextInt();
	}
	k--;
	for(int i=1;;i++)
	{
		if(k>=i)
		{
			k=k-i;
		}
		else
			break;
	}
	System.out.println(a[k]);
}
}
