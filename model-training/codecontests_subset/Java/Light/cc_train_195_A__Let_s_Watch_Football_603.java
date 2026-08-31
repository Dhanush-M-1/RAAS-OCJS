import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        long len = a*c;
        long res = len%b==0 ? len/b : len/b + 1;
        res -= c; 
        System.out.println(res<0 ? 0 : res);
    }

}