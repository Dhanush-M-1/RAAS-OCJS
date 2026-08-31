import java.util.Scanner;

public class A820 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int C = in.nextInt();
        int V0 = in.nextInt();
        int V1 = in.nextInt();
        int A = in.nextInt();
        int L = in.nextInt();
        int answer = 1;
        C -= V0;
        while (C > 0) {
            V0 = Math.min(V0+A, V1);
            C -= V0-L;
            answer++;
        }
        System.out.println(answer);
    }

}
