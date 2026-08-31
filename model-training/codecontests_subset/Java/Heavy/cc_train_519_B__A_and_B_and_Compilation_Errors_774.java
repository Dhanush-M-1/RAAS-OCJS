import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        long t = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] origin = new int[n];
        int[] fTime = new int[n - 1];
        int[] sTime = new int[n - 2];
        for (int i = 0; i < n; i++) {
            origin[i] = in.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            fTime[i] = in.nextInt();
        }
        for (int i = 0; i < n - 2; i++) {
            sTime[i] = in.nextInt();
        }
        Arrays.sort(origin);
        Arrays.sort(fTime);
        Arrays.sort(sTime);
        boolean find = false;
        for (int i = 0; i < fTime.length; i++) {
            if (origin[i] != fTime[i]) {
                find = true;
                System.out.println(origin[i]);
                break;
            }
        }
        if (find == false) System.out.println(origin[origin.length-1]);
        //
        find = false;
        for (int i = 0; i < sTime.length; i++) {
            if (fTime[i] != sTime[i]) {
                find = true;
                System.out.println(fTime[i]);
                break;
            }
        }
        if (find == false) System.out.println(fTime[fTime.length-1]);

    }
}