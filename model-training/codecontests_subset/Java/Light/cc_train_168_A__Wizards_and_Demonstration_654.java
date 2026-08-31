import java.util.Scanner;


public class WizardAndDemonstration {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	long n=sc.nextLong();
	long w=sc.nextLong();
	long p=sc.nextLong();
	
long required=	(long) Math.ceil(((double)(n*p))/100);
if(required>w)
System.out.println(required-w);
else
	System.out.println(0);
}
}
