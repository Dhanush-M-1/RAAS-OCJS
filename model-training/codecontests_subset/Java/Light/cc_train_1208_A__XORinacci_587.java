import java.util.*;
public class Main {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt();
        for (int i = 0; i <t ; i++) {
            long a=scan.nextInt();
            long b=scan.nextInt();
            long n=scan.nextInt();
            long c=a^b;
            if (n%3==0){
                System.out.println(a);
            }else if (n%3==1){
                System.out.println(b);
            }else {
                System.out.println(c);
            }

        }
    }

}