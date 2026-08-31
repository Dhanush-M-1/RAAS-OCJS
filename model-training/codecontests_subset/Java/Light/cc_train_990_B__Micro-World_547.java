
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class MicroWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();

		int n = s.nextInt();
		int k = s.nextInt();
		//int[] arr = new int[n+1];
		int[] count = new int[1000000*2];
		for (int i = 0; i < n; i++) {
			int x = s.nextInt();
			list.add(x);
			count[x]++;
		}
		int ans=0;
		Collections.sort(list);
		for(int i=n-1;i>=1;i--) {
			if(list.get(i)>list.get(i-1) && list.get(i-1)+k >= list.get(i)) {
				ans+= count[list.get(i-1)];
			}
		}
		System.out.println(n-ans);
//		Arrays.sort(arr);
//		int j = 0, count = 0;
//		for (int i = 1; i < n; i++) {
//
//			if (list.get(j) + k < arr[i]) {
//				j++;
//				continue;
//
//			}
//			if (arr[i] > list.get(j)) {
//				if (list.get(j) + k >= arr[i]) {
//					list.remove(j);
//					j++;
//					i--;
//				}
//			}
//		}
//		System.out.println(list);
//		System.out.println(list.size());

	}
}
