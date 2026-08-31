import java.util.*;
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            if (n ==0) System.out.println(a);
            else if (n==1) System.out.println(b);
            else if (n==2) System.out.println(a^b);
            else {
                if (n % 3 == 0) System.out.println(a);
                else if (n % 3 == 1) System.out.println(b);
                else System.out.println(a ^ b);
            }
            }
        }
    }

