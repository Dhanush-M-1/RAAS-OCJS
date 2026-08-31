
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class G {

    /**
     *
     *
     */


    public static void main(String[] args) throws IOException {
        // TODO code application logic here
Scanner in=new Scanner(System.in);
try (PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            int []origin=new int[n]; int []comp1=new int[n-1]; int []comp2=new int[n-2];
            int i=0;

            for (i = 0; i < n; i++) {
               origin[i]=in.nextInt();

            }
    for (i = 0; i <n-1; i++) {
        comp1[i]=in.nextInt();

    }
    for (i = 0; i <n-2; i++) {
        comp2[i]=in.nextInt();

    }

    Arrays.sort(origin);
    Arrays.sort(comp1);
    Arrays.sort(comp2);
    int val1=0;
    for (i = 0; i < n-1; i++) {
        if (origin[i]!=comp1[i]){val1=origin[i]; break;}

    }
    if (i==n-1)val1=origin[n-1];
    int val2=0;
    for (i = 0; i < n-2; i++) {
        if (comp2[i]!=comp1[i]){val2=comp1[i]; break;}

    }
    if (i==n-2)val2=comp1[n-2];
    out.println(val1);
    out.println(val2);
            out.close();
        }
    }

}