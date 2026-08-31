import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String y = in.next();
        String x = in.next();
        System.out.println(x+" "+y);
        int i=in.nextInt();
        while(i-->0){
            String z=in.next();
            if(z.equals(y)){
                y=in.next();
            }
            else{
                x=in.next();
            }
            System.out.println(x+" "+y);
        }
        // your code goes here
    }
}
