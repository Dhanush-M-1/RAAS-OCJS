import java.util.Scanner;

public class H39 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        StringBuilder output = new StringBuilder();
        for (int a=1; a<N; a++) {
            for (int b=1; b<N; b++) {
                output.append(Integer.toString(a*b, N)).append(' ');
            }
            output.append('\n');
        }
        System.out.print(output);
    }

}
