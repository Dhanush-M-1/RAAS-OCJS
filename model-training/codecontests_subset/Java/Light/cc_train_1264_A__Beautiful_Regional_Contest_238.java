import java.util.*;
import java.io.*;
public class Solution{
	public static void main(String[] argv)throws Exception {
		new Solver().solve1();
	}
}

class Solver{
	
	public void solve1() throws Exception {
		//Scanner sc = new Scanner(new File("input.txt"));
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++) {
				a[i]=sc.nextInt();
			}
			int temp=n/2;
			while(temp>0 && a[temp-1]==a[temp]) {
				temp--;
			}
			int g=1,s=0,b=0,i=1;
			while(i<temp && a[i]==a[0]) {
				g++;
				i++;
			}
			
			i+=g+1;
			if(i<temp) {
				s=g+1;
				while(i<temp && a[i]==a[2*g]) {
					s++;
					i++;
				}
				b=temp-i;
			}
			if(g<s && g<b) {
				System.out.println(g+" "+s+" "+b);
			}
			else {
				System.out.println("0 0 0");
			}
			
		}
		
	}
}


