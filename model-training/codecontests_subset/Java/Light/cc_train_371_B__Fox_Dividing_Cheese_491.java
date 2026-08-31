import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class A2OJLadder {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); int b = sc.nextInt();
        int a2 = 0, a3 = 0, a5 = 0, x = 0;
        int b2 = 0, b3 = 0, b5 = 0, y = 0;
    if(a==b){
        System.out.println(0);
        System.exit(0);
    }
        while (a>1 && x==0){
            if(a%5==0){
                a5++;
                a/=5;}
            else if (a%3==0){
                a3++;
                a/=3;}
            else if (a%2==0){
                a2++;
                a/=2;}
            else x=a;
        }

        while (b>1 && y==0){
            if(b%5==0){
                b5++;
                b/=5;}
            else if (b%3==0){
                b3++;
                b/=3;}
            else if (b%2==0){
                b2++;
                b/=2;}
            else y=b;
        }

        if(x!=y){
            System.out.println(-1);
        }else {
            int res = Math.abs(a2-b2) + Math.abs(a3-b3) + Math.abs(a5-b5);
            System.out.println(res);
        }
    }

    public static void print(String x){
        System.out.println(x);
    }

}
