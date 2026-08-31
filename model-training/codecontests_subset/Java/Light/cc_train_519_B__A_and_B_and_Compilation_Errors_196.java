
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A_BCompilationError {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in)
;
int n=sc.nextInt();
int a=0,b=0,c=0;
for(int i=0;i<n;i++)
{
	int x=sc.nextInt();
a=a+x;}
for(int i=0;i<n-1;i++)
{
	int x=sc.nextInt();
b=b+x;}
for(int i=0;i<n-2;i++)
{
	int x=sc.nextInt();
c=c+x;}
int fin=a-b;
int fin2=b-c;
System.out.println(fin);
System.out.println(fin2);

	}

}
