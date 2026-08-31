import java.util.*;

public class test {

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = Integer.parseInt(in.next());
    int K = Integer.parseInt(in.next());
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
        int a = Integer.parseInt(in.next());
        if (K % a == 0 && min > K/a) min = K/a;
    }
    System.out.println(min);
}
}
 
