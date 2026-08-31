import java.util.Scanner;

public class Stones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
        int a, b, c;
        t = sc.nextInt();
	    while(t--> 0)
        {
	    	a = sc.nextInt();
	    	b = sc.nextInt();
	    	c = sc.nextInt();

            int ans = 0, cnt;

            int x = Math.min(a, b / 2);
            int rem = b - (2 * x);
            cnt = x + 2 * x;
            x = Math.min(rem, c / 2);
            cnt += x + 2 * x;

            ans = cnt;
            cnt = 0;

            x = Math.min(b, c / 2);
            rem = b - x;
            cnt = x + 2 * x;
            x = Math.min(rem / 2, a);
            cnt += x + 2 * x;

            ans = Math.max(ans, cnt);
            System.out.println(ans);
        }
	    sc.close();
	}
}
