import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int div = a;
        int mod = 0;
        int c = a;

        while (div >= 1) {

            div = a / b;
            mod = a % b;

            c += div ;
            a = div+mod;

        }

        System.out.println(c);
    }

}
