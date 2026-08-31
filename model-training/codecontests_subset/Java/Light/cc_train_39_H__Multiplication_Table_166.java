import java.util.Scanner;

/**
 * Created by max_b on 2/1/2017.
 */
public class driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 1; i<n; i++){

            for(int o = 1; o<n; o++){
                Integer p = i*o;
                String q = Integer.toString(p, n);
                System.out.print(q+" ");
            }
            System.out.println();
        }
    }
}
