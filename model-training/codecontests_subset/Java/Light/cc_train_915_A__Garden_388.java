import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            if(k%a == 0 && min>k/a){
                min = k/a;
            }
        }
        System.out.println(min);
   }
}
