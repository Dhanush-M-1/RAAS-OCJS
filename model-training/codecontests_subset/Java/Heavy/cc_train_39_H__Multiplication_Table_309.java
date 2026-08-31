import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main
{
    
    static String toRadixK(int n,int k) {
			final int MAX = 1000;
			char[] arr = new char[MAX];
			int ind = MAX-1;
			while(n>0) {
				int rem = n%k;
				arr[ind--] = (char)(48+rem);
				n = n/k;
			}
			String res = new String(arr).trim();
			return res;
		}
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int k = sc.nextInt();
			
			for(int i=1;i<k;i++) {
				for(int j=1;j<k;j++) {
					String num = toRadixK(i*j,k);
					System.out.print(String.format("%-5s", num));
				}
				System.out.println();
			}
			
	
	}
}