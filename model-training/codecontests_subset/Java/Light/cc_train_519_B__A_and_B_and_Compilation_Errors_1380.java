import java.util.*;
public class Com
{
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int s1=0,s2=0,s3=0;
int a[]=new int[n];
int b[]=new int[n-1];
int c[]=new int[n-2];
for(int i=0;i<n;i++)
	a[i]=sc.nextInt();
for(int i=0;i<n-1;i++)
	b[i]=sc.nextInt();
for(int i=0;i<n-2;i++)
	c[i]=sc.nextInt();
for(int i=0;i<n;i++)
	s1=s1+a[i];
for(int i=0;i<n-1;i++)
	s2=s2+b[i];
for(int i=0;i<n-2;i++)
	s3=s3+c[i];
System.out.println(s1-s2);
System.out.println(s2-s3);
}
}		

