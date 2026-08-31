import java.util.*;

public class Codeforces {
	
	
	public static void main(String args[])
	{
	Scanner in =new Scanner(System.in);
	int n=in.nextInt();
	int a[]=new int[n];
	
	a[0]=in.nextInt();
	int max=a[0];
	int sum=a[0];
	for(int i=1;i<n;i++)
	{
		a[i]=in.nextInt();
		sum=sum+a[i];
		if(max<a[i])
			max=a[i];
	}
	
	//System.out.println(max);
	int win=0;
	for(int i=0;i<n;i++)
	{
		win=win+(max-a[i]);
		//System.out.println(win);
	}
	if(win>sum)
	{	System.out.println(max);
	}
	
	else
	{
		int d=sum-win;
		//System.out.println(sum+ " "+ win);
		//System.out.println(d);
		
		d=d/n;
		d++;
		System.out.println(d+max); 
		
		
	}
}
}
