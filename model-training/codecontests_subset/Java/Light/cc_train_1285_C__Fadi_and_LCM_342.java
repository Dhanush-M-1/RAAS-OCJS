import java.util.*;
import java.lang.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int c=0;
		for(int i=0;i<40;i++){
		    if(n==(long)Math.pow(2,i)){c++;break;}
		}
		if(c>0) System.out.println(n+" "+ 1);
		else{
		    long max = n;
		    int c1=0;
		    for(int i=(int)Math.sqrt(n);i>=1;i--){
		        if(n%i==0&&gcd(i,n/i)==1){
		                c1++;
		                System.out.println(i +" "+ n/i);
		                break;
		        }
		    }
		    if(c1==0) System.out.println(1+" "+n);
		}
	}
	   static long gcd(long a,long b){
	    if(b==0) return a;
	    else return gcd(b,a%b);
	}
}
