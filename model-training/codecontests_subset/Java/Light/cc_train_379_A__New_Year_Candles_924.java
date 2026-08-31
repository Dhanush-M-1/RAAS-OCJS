import java.io.*;
import java.util.*;

public class Q_379A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));

        int a = sc.nextInt();
        int b = sc.nextInt();
        // int hour = ((a*b)-1)/(b-1);
        int hour = a;
        while(a>=b){
            hour += a/b;
            a = a/b + a%b;
        }
        System.out.println(hour);
    }    
}