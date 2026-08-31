import java.util.Scanner;
import  java.math.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(Math.min(n/11, s.chars().filter(c->c=='8').count()));
    }
}
