import java.util.Scanner;
public class test3  {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = (a+b)/2;
        if (a < b) System.out.println((m - a)*(m - a + 1)/2 + (b - m)*(b - m + 1)/2);
        if (a > b) System.out.println((m - b)*(m - b + 1)/2 + (a - m)*(a - m + 1)/2);
    }    
}    