import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Test
 */
public class Test {
    static int[] x;
    public static void main(String[] args) throws IOException {
        int n,fir=0,sec=0;
        int[] a,b,c;

        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new BufferedReader(new FileReader("test.txt")));
        n = in.nextInt();

        a = new int[n];
        b = new int[n-1];
        c = new int[n-2];

        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        for(int i=0;i<n-1;i++){
            b[i] = in.nextInt();
        }

        for(int i=0;i<n-2;i++){
            c[i] = in.nextInt();
        }
        in.close();

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);        

        for(int i=0;i<n;i++){
            if(i<n-1){
                if(a[i] != b[i]){ fir = a[i]; break;}
            }else
                fir = a[i];
        }

        for(int i=0;i<n-1;i++){
            if(i<n-2){
                if(b[i] != c[i]){ sec = b[i]; break;}
            }else
                sec = b[i];
        }

        System.out.println(fir);
        System.out.println(sec);
        
    }
}