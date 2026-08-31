import java.util.Scanner;

public class a2oj {

    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = scan.nextInt();
        long result;
        if (n == 1) System.out.println(1);
        else if (n == 2) System.out.println(2);
        else if (n % 2 == 1) {
            result = (long) n * (n - 1) * (n - 2);
            System.out.println(result);
        } else {
            long re1 = (long) n*(n-1)*(n-2)/2;
            long re2 = (long) n*(n-1)*(n-3);
            if(n%3==0) re2 = re2/3;
            long re3 = (long) (n-1)*(n-2)*(n-3);
            result = (re1<re2?re2:re1);
            result = result<re3?re3:result;
            System.out.println(result);
        }
    }
}