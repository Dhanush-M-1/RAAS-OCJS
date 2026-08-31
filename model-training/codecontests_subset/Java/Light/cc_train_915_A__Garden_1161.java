import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;




/**
 *
 * @author Yan
 */
public class Test {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        int ans=10000;
        for (int i=0; i<n; i++){
            int z=in.nextInt();
            if (m%z==0) ans=Math.min(ans, m/z);
        }
        System.out.print(ans);
    }
}