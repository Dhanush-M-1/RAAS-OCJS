
import javax.management.QueryEval;
import  java.io.*;
import  java.math.*;
import java.nio.Buffer;
import java.sql.SQLSyntaxErrorException;
import  java.util.*;
import  java.text.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    public static double Pi=Math.acos(-1);

    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        while (T-- > 0) {
            int n = cin.nextInt();
            System.out.printf("%.7f\n", 1.0 / Math.sin(Pi / (2 * n)) * Math.cos(Pi / (4 * n)));
        }
    }

}









