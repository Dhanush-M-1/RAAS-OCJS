
import java.util.Scanner;

/**
 * May 7, 2016 | 4:00:51 PM
 * <pre>
 * <u>Description</u>
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 */
public class ProblemD{
    
    void solve(int n, int k, int a, int b, int c, int d) {
        if (n == 4) {
            System.out.println("-1");
            return;
        }
        if (k < n + 1) {
            System.out.println("-1");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(' ').append(c).append(' ');
        for (int i = 1; i <= n; i++) {
            if (i == a || i == b || i == c || i == d)
                continue;
            sb.append(i).append(' ');
        }
        sb.append(d).append(' ').append(b);
        
        sb.append('\n');
        sb.append(c).append(' ').append(a).append(' ');
        for (int i = 1; i <= n; i++) {
            if (i == a || i == b || i == c || i == d)
                continue;
            sb.append(i).append(' ');
        }
        sb.append(b).append(' ').append(d);
        System.out.println(sb);
    }
    
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            new ProblemD().solve(n, k, a, b, c, d);
        }
    }
}
