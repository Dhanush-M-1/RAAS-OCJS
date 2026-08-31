import java.io.*;
import java.util.*;
public class B181020 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
			while(t-->0) {
				
				int n  = Integer.parseInt(br.readLine());
				
				String s[] = new String[n];
				
				for(int i = 0; i<n; i++) {
					s[i] = br.readLine();
				}
				int a = Integer.parseInt(String.valueOf(s[0].charAt(1)));
				int b = Integer.parseInt(String.valueOf(s[1].charAt(0)));
				int x = Integer.parseInt(String.valueOf(s[n-2].charAt(n-1)));
				int y = Integer.parseInt(String.valueOf(s[n-1].charAt(n-2)));
				
				if(a+b == 0 && x+y == 0) {
					System.out.println(2);
					System.out.println(1+" "+2);
					System.out.println(2+" "+1);
				}
				if(a+b==2 && x+y==2) {
					System.out.println(2);
					System.out.println(1+" "+2);
					System.out.println(2+" "+1);
				}
				
				if(a+b == 1 && x+y==1) {
					System.out.println(2);
					if(a==1 && b==0) {
						System.out.println(1+" "+2);
					}
					else {
						System.out.println(2+" "+1);
					}
					if(x==0 && y==1) {
						System.out.println((n-1)+" "+(n));
					}
					else {
						System.out.println((n)+" "+(n-1));
					}
				}
				if(a+b == 1 && x+y==0) {
					System.out.println(1);
					if(a==1) {
						System.out.println(2+" "+1);
					}
					else {
						System.out.println(1+" "+2);
					}
				}
				if(a+b==0 && x+y==1) {
					System.out.println(1);
					if(x==1) {
						System.out.println((n)+" "+(n-1));
					}
					else {
						System.out.println((n-1)+" "+(n));
					}
				}
				if(a+b==0 && x+y==2) {
					System.out.println(0);
				}
				if(a+b==2 && x+y==0) {
					System.out.println(0);
				}
				if(a+b==2 && x+y==1) {
					System.out.println(1);
					if(x==1) {
						System.out.println((n-1)+" "+n);
					}
					else {
						System.out.println(n+" "+(n-1));
					}
				}
				
				if(a+b==1 && x+y==2) {
					System.out.println(1);
					if(a==1) {
						System.out.println(1+" "+2);
					}
					else {
						System.out.println(2+" "+1);
					}
				}
			}

	}

}
