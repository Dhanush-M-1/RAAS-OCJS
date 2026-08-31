import java.util.Scanner;

public class A615 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        boolean[] on = new boolean[M];
        for (int n=0; n<N; n++) {
            int X = in.nextInt();
            for (int x=0; x<X; x++) {
                on[in.nextInt()-1] = true;
            }
        }
        boolean possible = true;
        for (boolean isOn : on) {
            possible &= isOn;
        }
        System.out.println(possible ? "YES" : "NO");
    }
    
}
