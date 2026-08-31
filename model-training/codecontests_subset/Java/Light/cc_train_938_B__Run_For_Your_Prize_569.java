import java.util.*;
public class tv
{
public static void main(String[] args)
{                                                
int n,i;
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
int[] a=new int[n];
for(i=0;i<n;i++)
  a[i]=sc.nextInt();
int sum=0;
for(i=0;i<n;i++)
{
  if(a[i]<=500000)
       sum=a[i]-1;
  else
     break;
}
int s2=0;
for(i=n-1;i>=0;i--)
{
 if(a[i]>500000)
   s2=1000000-a[i];
 else
   break;
}
if(sum>=s2)
 System.out.println(sum);
else
  System.out.println(s2);
}}  
