import java.io.*;
import java.util.*;
public class Solution{
	//static String ans[]=new String[6];
	static Scanner sc=new Scanner(System.in);
	static void solve(){
		int n=sc.nextInt();
		int m=sc.nextInt();
		if(n>=m)
		System.out.println(n+1+(n-m)/(m-1));
		else System.out.println(n);
	}
	public static void main(String ars[]){
		solve();
	}
}