import java.util.*;
class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int[] a = new int[N];
	int max = 0;
	long result = 0;
	for(int i = 0; i<N; i++) {
	    a[i] = sc.nextInt();
	    max = Math.max(max, a[i]);
	    result += a[i] - 1;
	}
	System.out.println(result);
    }
}