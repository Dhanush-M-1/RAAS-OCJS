import java.util.*;
public class p168A {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int n = x * z;
        n = n % 100 == 0 ? n / 100 : n / 100 + 1;
        System.out.println(n - y > 0 ? n - y : 0);
    }
}