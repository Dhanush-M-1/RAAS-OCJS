import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class Pair {

    public static void main(String[] args) throws Exception {

        try {
            Scanner sc = new Scanner(System.in);
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int c3 = sc.nextInt();
            int c4 = sc.nextInt();
            int c5 = sc.nextInt();
            int sum = c1+c2+c3+c4+c5;
            if( sum==0 || sum%5!=0){
                System.out.println("-1");
            }
            else{
                System.out.println(sum/5);
            }
        }
        catch (Exception e) {
        }
    }
}