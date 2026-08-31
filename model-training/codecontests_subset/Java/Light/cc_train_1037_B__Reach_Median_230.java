import java.util.*;
public class median
{
public static void main(String[] args)
{
long s,m,sum=0;
int i,n;
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
s=sc.nextLong();
long[] arr=new long[n];
for(i=0;i<n;i++)
 arr[i]=sc.nextLong();
Arrays.sort(arr);
m=arr[n/2];
if(m<s)
{
for(i=n/2;i<n;i++)
{
if(arr[i]<s)
  sum+=(s-arr[i]);
else
  break;
}
}
else
{
for(i=0;i<n/2+1;i++)
{
if(arr[i]>s)
  sum+=(arr[i]-s);
}
}
System.out.println(sum);
}
}