

import java.util.Scanner;
public class disjoint{	
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	int [] a=new int[n];
	int i;
	for(i=0;i<n;i++)
	a[i]=scan.nextInt();
	
	long sum=0;
for(i=0;i<n;i++)
sum+=a[i];
	

sum=sum/100;
if(sum%2==0&&a.length>1)	
{
	int count=0;
for(i=0;i<n;i++)
{
	if(a[i]==200)
	count++;
	
	
}

if(count==(a.length))
{
	if(count%2==0)
	{
		System.out.println("YES");
	}
	else {
		System.out.println("NO");
	}
	
	
}
else
System.out.println("YES");	

}
else
System.out.println("NO");	

}

}
