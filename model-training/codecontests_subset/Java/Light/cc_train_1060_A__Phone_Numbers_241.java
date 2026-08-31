import java.util.Scanner;

public class A1060 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String s = in.next();
        int eights = 0;
        for (int n=0; n<N; n++) {
            char c = s.charAt(n);
            if (c == '8') {
                eights++;
            }
        }
        int answer = Math.min(s.length()/11, eights);
        System.out.println(answer);
    }

}
