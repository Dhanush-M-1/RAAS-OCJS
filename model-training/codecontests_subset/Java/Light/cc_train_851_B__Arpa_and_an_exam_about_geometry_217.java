import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner bb = new Scanner(System.in);
        long a = bb.nextInt(); 
        long b = bb.nextInt(); 
        long c = bb.nextInt(); 
        long d = bb.nextInt(); 
        long e = bb.nextInt(); 
        long f = bb.nextInt();
        boolean ans = ((f-d)*(c-a) != (d-b)*(e-c)) && ((f-d)*(f-d) + (e-c)*(e-c) == (d-b)*(d-b) + (c-a)*(c-a));
        if(!ans)
            System.out.println("No");
        else
            System.out.println("Yes");
    }
}