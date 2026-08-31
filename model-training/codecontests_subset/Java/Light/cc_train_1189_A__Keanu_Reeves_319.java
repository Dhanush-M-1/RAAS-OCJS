import java.util.Scanner;

public class A1189 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String S = in.next();
        int zeros = 0;
        for (int i=0; i<N; i++) {
            if (S.charAt(i) == '0') {
                zeros++;
            }
        }
        if (N%2 == 0 && 2*zeros == N) {
            System.out.println("2");
            System.out.println(S.charAt(0) + " " + S.substring(1));
        } else {
            System.out.println("1");
            System.out.println(S);
        }
    }

}
