import java.util.Scanner;
class Main
{
public static void main(String args[])
{
Scanner scan=new Scanner(System.in);
while(true)
{
int l=scan.nextInt();
if(l==0)break;
int sum=0,x=0;
for(int i=1;i<=12;i++)
	{
	int m,n;
	m=scan.nextInt();
	n=scan.nextInt();
	sum+=m-n;
	
if(sum>=l && x==0)x=i;


	}
	if(sum>=l)System.out.println(x);
	else System.out.println("NA");
}
}
}