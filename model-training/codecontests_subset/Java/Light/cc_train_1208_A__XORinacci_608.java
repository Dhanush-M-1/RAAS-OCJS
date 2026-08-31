import java.util.Scanner;

public class XORinacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int n = s.nextInt();
            int c = a ^ b;
            if(n % 3 == 0) System.out.println(a);
            else if(n % 3 == 1) System.out.println(b);
            else System.out.println(c);
            }
        }
    }