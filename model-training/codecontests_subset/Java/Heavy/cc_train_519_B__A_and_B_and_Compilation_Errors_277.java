import java.util.*;
public class Main{
public static void main(String[] args){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
 
        int[] a=new int[n];
        int[] b=new int[n-1];
        int[] c=new int[n-2];
        for(int i=0;i<n;i++)
        {
            a[i]=in.nextInt();
        }
        for(int i=0;i<n-1;i++)
        {
            b[i]=in.nextInt();
        }
        for(int i=0;i<n-2;i++)
        {
            c[i]=in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
       boolean flag=false;
for(int i=0;i<n-1;i++)
{
if(b[i]!=a[i])
{
flag=true;
System.out.println(a[i]);
break;
}
}
if(flag==false)
System.out.println(a[n-1]);
flag=false;
for(int i=0;i<n-2;i++)
{
if(c[i]!=b[i])
{
flag=true;
System.out.println(b[i]);
break;
}}
if(flag==false)
System.out.println(b[n-2]);
}
}
