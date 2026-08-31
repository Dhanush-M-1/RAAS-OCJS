import java.util.*;

public class KosyaReshaetZadachi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        for(int i = 0; i < t; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            int ans = 0;

            int s = Math.min(b, c / 2);
            ans = s * 3;
            b = b - s;

            s = Math.min(a, b / 2);
            ans = ans + s * 3;

            System.out.println(ans);
        }


    }
}
