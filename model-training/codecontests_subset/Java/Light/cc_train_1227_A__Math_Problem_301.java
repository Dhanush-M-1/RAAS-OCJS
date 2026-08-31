import java.util.Scanner;
import java.util.*;
import java.io.*;

public class CodeForcesFormat {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t>0){
           int n = input.nextInt();
           int max = 0 ;
           int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++){            
                max = Math.max(max, input.nextInt());
                min = Math.min(min, input.nextInt());
            }
            System.out.println(Math.max(max-min, 0));
            t--;
        }
    }
}
