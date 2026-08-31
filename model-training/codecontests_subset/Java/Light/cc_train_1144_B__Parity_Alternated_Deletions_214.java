import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int n;
	private static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q1 = new LinkedList<>();//odd
		Queue<Integer> q2 = new LinkedList<>();//even
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if((a&1)==1) {
				q1.add(a);
			}else {
				q2.add(a);
			}
		}
		int length = Math.abs(q1.size()-q2.size());
//		System.out.println(length);
//		System.out.println(q1.size());
//		System.out.println(q2.size());
		if(length==1) {
			System.out.println("0");
		}else if(q1.size()>q2.size()) {//odd大
			Collections.sort((List<Integer>) q1,(a,b)->((a>b)?1:(a==b?0:-1)));
			for(int i = 0;i<length-1;i++) {
				sum+=q1.poll();
			}
			System.out.println(sum);
		}else {
			Collections.sort((List<Integer>) q2,(a,b)->((a>b)?1:(a==b?0:-1)));
			for(int i = 0;i<length-1;i++) {
				sum+=q2.poll();
			}
			System.out.println(sum);
		}
	}
}
