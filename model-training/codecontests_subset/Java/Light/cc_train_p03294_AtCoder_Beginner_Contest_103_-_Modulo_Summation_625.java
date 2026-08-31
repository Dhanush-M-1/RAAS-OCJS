import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] a = new int[n];
		for(int i=0; i<a.length; ++i){
			a[i] = scn.nextInt();
		}
		int sum = 0;
		for(int i=0; i<a.length; ++i){
			sum = sum + a[i];
		}
		int ans = sum - n;
		System.out.println(ans);
	}
}
