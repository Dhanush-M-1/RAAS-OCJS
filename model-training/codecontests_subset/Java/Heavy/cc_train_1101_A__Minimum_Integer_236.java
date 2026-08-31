import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the palindromeIndex function below.
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t=scanner.nextInt();
        for(int i=0;i<t;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            if(c<a){
                System.out.println(c);
            }else {
               System.out.println((b/c+1)*c);
            }
        }
    }
}