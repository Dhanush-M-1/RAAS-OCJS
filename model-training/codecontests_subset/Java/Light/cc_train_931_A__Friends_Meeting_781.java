import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int tiredness = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        	int mid = min + (max-min)/2;
        	int temp = 1;
        	for(int i = 0; i<(mid-min); i++) {
        		tiredness = tiredness + (temp*2);
        		temp = temp + 1;
        	}

        if(((max-min)&1) == 1) {
        	tiredness = tiredness + temp;
         }
        if(tiredness == 0) {
        	System.out.println(max-min);
        } else {
        System.out.println(tiredness);
        }
    }

   
}