import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.next());

        int ans = 0;
        for(int i = 0; i < N; i++){
            ans += Integer.parseInt(scan.next()) -1;
        }

        System.out.println(ans);
    }
}