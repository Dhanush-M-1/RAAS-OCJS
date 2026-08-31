import java.util.*;

public class Main {
    public static void main(String args[]) {
       ///値を取得
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int c = sc.nextInt();
       
       //出力
       if(a + b == c || a + c == b || b + c == a ) {
       System.out.println("Yes");
       } else {
           System.out.println("No");
       }
    }
}