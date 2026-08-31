import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int k = Math.abs(b-a);
		int result;
		int t = k/2;
		if(k%2 == 0) {
			result = t*(t+1); 
		} else {
			result = t*(t+1) + t + 1;
		}
		System.out.println(result);
	}
}