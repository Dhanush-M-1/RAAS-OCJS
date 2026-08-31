import java.util.Scanner;

public class CF209B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long A = in.nextLong();
        long B = in.nextLong();
        long C = in.nextLong();

        long ans = Math.max(A,Math.max(B,C));
        if(A%2 == B%2) ans = Math.min(ans, Math.max(A,B));
        if(A%2 == C%2) ans = Math.min(ans, Math.max(A,C));
        if(B%2 == C%2) ans = Math.min(ans, Math.max(B,C));

        System.out.println(ans);
    }
}
