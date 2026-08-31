import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n-1];
        Arrays.setAll(a, i -> stdIn.nextInt());
        Arrays.setAll(b, i -> stdIn.nextInt());
        Arrays.setAll(c, i -> stdIn.nextInt());
        int ans = b[a[0]-1];
        for(int i = 1 ; i < n; i++ )
            ans += b[a[i]-1] +(a[i] - a[i-1] == 1 ? c[a[i-1]-1] : 0);
        System.out.println(ans);
    }
}