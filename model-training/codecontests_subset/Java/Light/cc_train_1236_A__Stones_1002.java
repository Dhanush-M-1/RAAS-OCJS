import java.util.Scanner;

public class A1236 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int answer = 0;
            int count = Math.min(B, C/2);
            answer += 3*count;
            B -= count;
            count = Math.min(A, B/2);
            answer += 3*count;
            System.out.println(answer);
        }
    }

}
