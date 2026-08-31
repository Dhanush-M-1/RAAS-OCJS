
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			String str=sc.next();
			int sum=0;
			char c[]=str.toCharArray();
			for(int i=0;i<str.length()-1;i++) {
				if(c[i]=='?') {
					continue;
				}
				if(i<str.length()-2&&c[i]==c[i+2]) {
					c[i+2]='?';
					sum++;
				}
				if(c[i]==c[i+1]) {
					c[i+1]='?';
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
}

 				 	  	  	        	 		 	 	 	