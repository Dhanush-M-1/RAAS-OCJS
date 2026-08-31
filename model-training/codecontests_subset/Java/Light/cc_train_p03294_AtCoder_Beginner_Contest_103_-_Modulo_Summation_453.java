import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		int[] a = new int[N];
		for(int i=0;i<N;i++)a[i] = sc.nextInt();
		for(int i=0;i<N;i++){
			sum += a[i]-1;
		}
		System.out.println(sum);
	}
}