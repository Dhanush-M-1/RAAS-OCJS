import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < s; i++){
            int a = sc.nextInt();
            sum += a;
        }
        System.out.println(sum-s);
    }
}