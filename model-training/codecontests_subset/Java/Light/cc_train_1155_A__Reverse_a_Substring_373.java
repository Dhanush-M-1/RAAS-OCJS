import java.util.Scanner;
public class Ishu
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int n,i,l=0,r=0;
	boolean flag=false;
	char max;
	String str;
	char[] ch=new char[300000];
	n=scan.nextInt();
	str=scan.next();
	ch=str.toCharArray();
	max=ch[0];
	for(i=0;i<n;++i)
		{
		if(ch[i]>=max)
			{
			max=ch[i];
			l=i+1;
			}
		else 
			{
			flag=true;
			r=i+1;
			break;
			}
		}
	if(!flag)
		System.out.println("NO");
	else 
		{
		System.out.println("YES");
		System.out.println(l+" "+r);	
		}	
	}			
}