import java.util.Scanner;

public class A433 {
    public static void main(String[] args) {
        int n, g;
        int n100 = 0, n200 = 0;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 0; i < n; i++) {
            g = s.nextInt();
            if(g == 100){
                n100++;
            }
            else
                n200++;
        }
        if(n200 % 2 == 1){
            n100 = n100 - 2;
        }
        if(n100 % 2 == 1 || n100 < 0){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}