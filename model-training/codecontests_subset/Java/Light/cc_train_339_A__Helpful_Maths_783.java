import java.util.Arrays;
import java.util.Scanner;

public class que20 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int[] arr = new int[s.length()/2+1];
		int v=0;
		for (int i = 0; i < s.length(); i += 2) {
			arr[v] = s.charAt(i)-'0';
			v++;
		}
	Arrays.sort(arr);
	StringBuilder sb=new StringBuilder(s);
	int a=0;
	for(int i=0;i<sb.length();i+=2){
		sb.setCharAt(i, (char)(arr[a]+'0'));
		a++;
	}
	System.out.println(sb.toString());
	}

}
