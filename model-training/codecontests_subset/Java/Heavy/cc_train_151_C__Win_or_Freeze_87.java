import java.io.*;
import java.util.*;
public class Solution {
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	//Main
	public static void main(String args[]) {
		int test=1;
		//test=sc.nextInt();
		while(test-->0) {
			//Focus
			long n=sc.nextLong();
    		ArrayList<Long> arr=new ArrayList<>();
    		for(long i=2;i*i<=n;i++) {
    			while(n%i==0) {
    				arr.add(i);
    				n/=i;
    			}
    		}
    		if(n>1) arr.add(n);
    		if(arr.size()==2) out.println(2);
    		else if(arr.size()<=1) out.println(1+"\n"+0);
    		else out.println(1+"\n"+(arr.get(0)*arr.get(1)));
		}
		out.flush();
		out.close();
	}
}
