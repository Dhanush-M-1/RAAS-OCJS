//package leto;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1110_ {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		String pass = scan.next();
		int n = scan.nextInt();
		String s = ""; 
		boolean beg = false;
		boolean end = false;
		for(int i = 0;i<n;i++){
			s = scan.next();
			if(s.compareTo(pass) == 0){
				beg=  true;
				end = true;
				break;
			}
			if(s.charAt(0) == pass.charAt(1)){
				beg = true;
			}
			if(s.charAt(1) == pass.charAt(0)){
				end = true;
			}
		}
		if((beg)&&(end)){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
