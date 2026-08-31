import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    static int min(int a,int b) {
        return a>b? b : a;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inp = new Scanner(System.in);
        int a = inp.nextInt();
        int b = inp.nextInt();
        
        if(b-a > 1)
            System.out.println(2);
        else {
            int x = gcd(a,b);
            if(x != 1)
                System.out.println(x);
            else
            {
                if(a%2 == 0 || b%2 == 0)
                    System.out.println(2);
                else
                    System.out.println(a);
            }
        }
    }
    static public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    static void sort(int[] a) {
        for(int i = 0 ; i < a.length ; ++i)
            for(int j = 1 ; j <a.length - i ; ++j)
                if(a[j] < a[j-1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = a[j];
                }
    }

    static short[] numOfDivisors(int size) {
        short numOfDiv[] = new short[size + 1];
        for(int i = 1; i <= size ; ++i)
            for(int j = i ; j <= size ; j+=i)
                numOfDiv[j]++;
        return numOfDiv;
    }

}