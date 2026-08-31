import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
	Integer A[] = new Integer[N];
	int ans = 0;
        for ( int i = 0; i < N; i++ ) {
            A[i] = sc.nextInt();
	    ans += A[i]-1;
        }
	System.out.println(ans);
    }
}
