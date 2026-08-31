import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		String inp = scan.next();
		int[] arr = new int[4];
		for(char c : inp.toCharArray()) {
			if(c != '+') {
				arr[c-'0']++;
			}
		}
		
		String res = "";
		for(int i = 1 ; i < arr.length ; i++) {
			while(arr[i]-->0) {
				res += String.valueOf(i) +"+";
			}
		}
		System.out.println(res.substring(0,res.length()-1));
	}
}