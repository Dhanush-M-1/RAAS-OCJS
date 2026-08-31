import java.util.Scanner;
public class Ishu
{
	public static void main(String []args)
	{
	Scanner scan=new Scanner(System.in);
	int c,v0,v1,a,l,pages=0,ans=0,temp=0;
	c=scan.nextInt();
	v0=scan.nextInt();
	v1=scan.nextInt();
	a=scan.nextInt();
	l=scan.nextInt();
	while(pages<c)
		{
		if(v0+temp*a<=v1)
			{
			pages+=v0+temp*a;
			++ans;
			++temp;
			}
		else
			{
			pages+=v1;
			++ans;
			}
		if(ans>=2)
			pages-=l;
		}
	System.out.println(ans);
	}
}