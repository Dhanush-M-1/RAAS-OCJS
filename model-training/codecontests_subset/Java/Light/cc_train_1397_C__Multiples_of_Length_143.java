import java.util.Scanner;

public class demo_C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder print = new StringBuilder();

        int t;
        t = scan.nextInt();

        long a[] = new long[t+1];
        for (int i = 1; i <= t; i++) {
            a[i] = scan.nextLong();
        }




        if(t != 1){
            print.append(1 + " ");
            print.append(t-1);
            print.append('\n');
            for (int i = 1; i <= t - 1; i++) {
                long sub = a[i];
                sub *= t - 1;
                a[i] += sub;
                print.append(sub + " ");
            }
        }else{
            print.append(1 + " ");
            print.append(1);
            print.append('\n');
            long sub = 0-a[1];
            a[1] += sub;
            print.append(sub);
        }

        print.append('\n');
        print.append(t + " ");
        print.append(t);
        print.append('\n');

        long ans1 = a[t];
        ans1 *= t-1;
        a[t] += ans1;
        print.append(ans1);
        print.append('\n');

        print.append(1 + " ");
        print.append(t);
        print.append('\n');

        for (int i = 1; i <= t; i++) {
            long ans = 0-a[i];
            a[i] += ans;
            print.append(ans+" ");
        }

        System.out.println(print);
    }
}
