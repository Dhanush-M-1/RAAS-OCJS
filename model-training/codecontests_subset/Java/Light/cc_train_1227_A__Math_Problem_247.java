import java.util.*;
public class Main {
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
     int t=sc.nextInt();
     for(int h=0;h<t;h++)
     {
     int n=sc.nextInt();
int[] a=new int[n];
int[] b=new int[n];
for(int k=0;k<n;k++)
{
    a[k]=sc.nextInt();
    b[k]=sc.nextInt();
}Arrays.sort (a);
Arrays.sort(b);
if(n==1)
System.out.println("0");
else
{int p=Math.max(0,a[n-1]-b[0]);System.out.println(p);}
     }
    }
}
     