import java.util.Scanner;
public class Ishu
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int n,i,zero=0,one=0;
	String str;
	n=scan.nextInt();
	str=scan.next();
	for(i=0;i<n;++i)
		{
		if(str.substring(i,i+1).equals("0"))
			++zero;
		else
			++one;
		}
	if(zero==one)
		{
		System.out.println(2);	
		System.out.println(str.substring(0,1)+" "+str.substring(1,n));
		}
	else
		{
		System.out.println(1);
		System.out.println(str);
		}
	}
}