import java.util.*;

public class S195{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		

		int n=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();

	 int tsize=n*b;
	 if(tsize%a==0){

	 	System.out.println(tsize/a-b);
	 }
	 else {
	 	System.out.println((tsize)/a+1-b);
	 }
	}
}