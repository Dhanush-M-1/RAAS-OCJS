import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++)
        	arr[i] = sc.nextInt();
        boolean[] same = new boolean[n+1];
        for(int i = 1; i <= n; i++)
        	same[i] = (arr[i] == i);

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
        	if(!same[i]) continue;
        	cnt++;
        	if(i < n && same[i+1]) i++;
        }
        System.out.println(cnt);
    }
}
