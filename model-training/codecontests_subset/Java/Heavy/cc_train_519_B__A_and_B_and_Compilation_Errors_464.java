import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class Pair {

    public static void main(String[] args) throws Exception {

        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[]arr = new int[n];
            int[]second = new int[n-1];
            int[]third = new int[n-2];
            int sum1=0;
            int sum2=0;
            int sum3=0;
            for(int i=0;i<arr.length;i++){
                arr[i] = sc.nextInt();
                sum1+=arr[i];
            }
            for(int i=0;i<second.length;i++){
                second[i] = sc.nextInt();
                sum2+=second[i];
            }
            for(int i=0;i<third.length;i++){
                third[i] = sc.nextInt();
                sum3+=third[i];
            }
            System.out.println((sum1-sum2)+" "+" \n"+(sum2-sum3));
        }
        catch (Exception e) {
        }
    }
}