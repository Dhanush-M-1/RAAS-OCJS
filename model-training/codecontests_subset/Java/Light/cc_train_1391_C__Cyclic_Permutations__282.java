import java.io.*;
import java.util.*;

public class hello {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) {
		int t=1;
//		t=sc.nextInt();
		while(t-->0){
		    new hello().solve();
		}
	}
	void solve(){
		long i,n=sc.nextLong(),an=1,m=(long)(1e9+7);
		for(i=1;i<=n;i++)	an=(an*i)%m;
		an=(an-pom(2,n-1,m)+m)%m;
		System.out.print(an);
	}
	long pom(long x,long y,long m){
		long an=1;
		x=x%m;
		while(y>0){
			if(y%2==1)	 an=(an*x)%m;
			y=y>>1;
			x=(x*x)%m;
		}
		return an;
	}
}