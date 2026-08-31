import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0)
        {
            --t;
            int n = in.nextInt();

            int c_2=0, c_3 =0;
            while (n%2==0)
            {
                ++c_2;
                n/=2;
            }
            while (n%3==0)
            {
                ++c_3;
                n/=3;
            }

            if (n == 1 && c_3 >= c_2){
                System.out.println(2 * c_3 - c_2);
            }
            else {
                System.out.println(-1);
            }

        }

    }
}

