import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inp = new Scanner(System.in);
        int a = inp.nextInt();
        int b = inp.nextInt();
        if(b-a > 1)
            System.out.println(2);
        else {
            int x = gcd(a,b);
            System.out.println(x!=1?x:a);
        }
    }

    static public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

}