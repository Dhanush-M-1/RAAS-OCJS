
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.text.NumberFormat;
//import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> atemp = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> b = new HashMap<String, Integer>();
        HashMap<String, Integer> c = new HashMap<String, Integer>();
        int n = input.nextInt();
        int temp;
        for (int i = 0; i < n; i++) {
            temp = input.nextInt();
            atemp.add(temp);
            if (map.get(Integer.toString(temp)) == null) {
                map.put(Integer.toString(temp), 1);
            } else {

                map.put(Integer.toString(temp), map.get(Integer.toString(temp)) + 1);
            }
            b.put(Integer.toString(temp), 0);
            c.put(Integer.toString(temp), 0);

        }
        for (int i = 0; i < n - 1; i++) {
            temp = input.nextInt();

            if (b.get(Integer.toString(temp)) == null) {
                b.put(Integer.toString(temp), 1);
            } else {

                b.put(Integer.toString(temp), b.get(Integer.toString(temp)) + 1);
            }

        }
        for (int i = 0; i < n - 2; i++) {
            temp = input.nextInt();

            if (c.get(Integer.toString(temp)) == null) {
                c.put(Integer.toString(temp), 1);
            } else {

                c.put(Integer.toString(temp), c.get(Integer.toString(temp)) + 1);
            }

        }
        String temp2;
        String res="";
        for (int x : atemp) {
            temp2 = Integer.toString(x);
            if (map.get(temp2).equals(b.get(temp2))) {

            } else {
                res=temp2;
            }
        }
        System.out.println(res);
        
        for (int x : atemp) {
            temp2 = Integer.toString(x);
            if (b.get(temp2).equals(c.get(temp2))) {

            } else {
               res=temp2;
            }

        }
        System.out.println(res);
    }
}