
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), k = s.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		PriorityQueue<Integer>[] arr = new PriorityQueue[200001];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer A, Integer B) {
					return B - A;
				}
			});
		}
		long[] sum = new long[200001];
		for(int i = 0; i < n; i++) {
			int temp = a[i], count = 0;
			while(temp > 0) {
				if(arr[temp].size() == k && count < arr[temp].peek()) {
					sum[temp] -= arr[temp].poll();
					sum[temp] += count;
					arr[temp].add(count);
				} else if(arr[temp].size() < k){
					sum[temp] += count;
					arr[temp].add(count);
				}
				temp /= 2;
				count++;
			}
			if(arr[temp].size() == k && count < arr[temp].peek()) {
				sum[temp] -= arr[temp].poll();
				sum[temp] += count;
				arr[temp].add(count);
			}
		}
		long ans = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].size() == k) {
				ans = Math.min(sum[i], ans);
			}
		}
		System.out.println(ans);
	}

}
