import java.util.*;
import java.io.*;

public class A {

	static class pair {
		String x;
		int y;

		public pair(String d, int k) {
			x = d;
			y = k;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		char[] a=sc.next().toCharArray();
		int c=0;
		for(int i=n-1;i>n-x-1;i--) {
//			System.out.println(i);
			if(i==n-y-1) {
				if(a[i]=='0')
					c++;
			}
			else{
				if(a[i]=='1')
					c++;
			}
		}
		pw.println(c);
		pw.flush();
		pw.close();

	}

}
