
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
    public static int MOD = 1000000007;
    public static BigInteger big_mod = BigInteger.valueOf(MOD);
    static List<Long> list = new ArrayList<Long>();

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine().toLowerCase();
        int n = Integer.parseInt(in.readLine());
        String fin = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < n + 97) {
                fin += Character.toUpperCase(s.charAt(i));
            }
            else
                fin += Character.toLowerCase(s.charAt(i));
        }
        System.out.println(fin);
    }}