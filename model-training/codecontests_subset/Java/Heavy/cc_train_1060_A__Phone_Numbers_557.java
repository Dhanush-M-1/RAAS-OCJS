/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	//	System.out.println("Hello World");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int c=0,i;
	String s=sc.next();
	int n1=n/11;
	char a[]=s.toCharArray();
	for(i=0;i<a.length;i++)
	{
	    if(a[i]=='8')
	    c++;
	}
	if(c>=n1)
System.out.println(n1);
else if(c<n1)
{
 System.out.println(c);   
}
else if(c==0)
{
    System.out.println(c);
}
	}
}
