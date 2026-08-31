import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            ans += sc.nextInt() - 1;
        }
        System.out.println(ans);

    }

}
