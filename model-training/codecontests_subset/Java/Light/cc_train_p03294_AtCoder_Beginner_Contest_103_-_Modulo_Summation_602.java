import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N];
		int ans = 0;
		for(int i = 0; i < N; i++){
		    a[i] = sc.nextInt()-1;
		    ans += a[i];
		}
		System.out.println(ans);
	}
}