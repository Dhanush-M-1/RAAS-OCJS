import java.util.*;
import java.io.*;
class Main{
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out, true);
		int n=in.nextInt();
		int count=0;
		for(int i=0;i<n;i++){
			int a=in.nextInt();
			if(check_prime(a))
				count++;
		}
		out.println(count);
	}
	public static boolean check_prime(int n){
		if(n<=1)
			return false;
		if(n<=3)
			return true;

		if(n%2==0 || n%3==0)
			return false;

		for(int i=5; i*i<=n; i=i+6){
			if(n%i==0 || n%(i+2)==0)
				return false;
		}
		return true;
	}
}
