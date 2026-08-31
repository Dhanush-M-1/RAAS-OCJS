import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Code {

    private static boolean isSorted(String s) {
        for(int i = 1; i < s.length(); i ++) {
            if(s.charAt(i-1) > s.charAt(i)) return false;
        }
        return true;
    }

    private static String findConsequtiveDecreasing(String s) {
        for(int i = 1; i < s.length(); i ++) {
            if(s.charAt(i-1) > s.charAt(i)) return "" + (i) + " " + (i+1);
        }
        return "Error";
    }

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        int wordLength = scanner.nextInt(); 
        String word =  scanner.next();

        if(isSorted(word)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(findConsequtiveDecreasing(word));
        }
    }
}
