import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void convertStringArray (String[] strArr, int[] intArr) {
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
    }

    public static void convertStringArray (String[] strArr, Long[] longArr) {
        for (int i = 0; i < strArr.length; i++) {
            longArr[i] = Long.parseLong(strArr[i]);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        int r = 0;
        char[] a = br.readLine().toCharArray();

        for (int i = x; i>0; i--) {
            if (i == y+1) {
                if (a[n-i] != '1') r++;
            } else {
                if (a[n-i] != '0') r++;
            }
        }

        System.out.println(r);
    }
}