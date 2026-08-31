import java.util.*;
public class honey
{
public static void main(String ar[])
{
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int c=in.nextInt();
int arr[]=new int[n];
for(int i=0;i<n;i++)
	arr[i]=in.nextInt();
int max=arr[0]-arr[1]-c;
for(int j=0;j+1<n;j++)
{
if(arr[j]-arr[j+1]-c>max)
max=arr[j]-arr[j+1]-c;
}
if(max<0)
max=0;
System.out.println(max);
}
}