import java.util.*;
public class cf303div2C {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int h[]=new int[n];
int x[]=new int[n];
for(int i=0;i<n;i++)
{x[i]=sc.nextInt();
h[i]=sc.nextInt();}
int s=Math.min(2,n);
for(int i=1;i<n-1;i++)
{if(x[i]-x[i-1]>h[i])
s++;
else if(x[i+1]-x[i]>h[i])
{s++;x[i]=x[i]+h[i];}
}
System.out.println(s);
sc.close();

}
}