
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class badDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		Arrays.sort(arr);
		int[] ways = new int[max+1];
		int[] count = new int[max+1];
		for(int i = 0; i < n; i++) {
			int x = arr[i];
			int div = 0;
			while(x>0) {
				if(count[x]<k) {
					count[x]+=1;
					ways[x]+=div;
				}
				div++;
				x=x/2;
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < ways.length; i++) {
			if(count[i]==k) {
				int way = ways[i];
				if(way<ans) {
					ans = way;
				}
			}
		}
		System.out.println(ans);
	}
}
