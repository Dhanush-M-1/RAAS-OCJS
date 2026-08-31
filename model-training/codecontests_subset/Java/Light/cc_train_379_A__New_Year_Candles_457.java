import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int hour = 0;
        int remain = 0;
        while(n > m-1){
            remain = n%m;
            n = n - n%m;
            hour += n;
            n = n/m + remain;
            //System.out.println(n);
        }

        System.out.println(hour+n);
    }

}