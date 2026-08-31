import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.*;
public class Main{
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		long n,p,w,d;
		n=scanner.nextLong();
		p=scanner.nextLong();
		w=scanner.nextLong();
		d=scanner.nextLong();
		long x=p/w,y=0,z=0;
		long s=p%w;
		if(w%d==0&&p%d!=0) {
			System.out.println(-1);
			return;
		}
		for(int i=0;i<n;i++) {
			if(x-i+(s+i*w)/d+z>n||x-i<0) {
				System.out.println(-1);
				return;
			}
			if((s+i*w)%d==0) {
				System.out.println(x-i+" "+((s+i*w)/d)+" "+(n-(x-i)-((s+i*w)/d)));
				return;
			}
		}
	}
}












