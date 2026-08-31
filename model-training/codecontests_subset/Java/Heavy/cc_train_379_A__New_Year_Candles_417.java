import java.util.*;
import java.lang.*;
import java.io.*;
public class JavaApplication9 {

    
    public static void main(String[] args) throws Exception{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] ar;
        StringBuilder sb = new StringBuilder();
        //-----------------------------------------------------------------------
        ar = br.readLine().split(" ");
        int a = Integer.parseInt(ar[0]);
        int b = Integer.parseInt(ar[1]);
        int h = 0;
        int c = 0;
        while(a > 0) {
            c++;
            h++;
            a--;
            if (c == b) {
                c = 0;
                a++;
            }
        }
        sb.append(h + "\n");
        //-----------------------------------------------------------------------
        System.out.print(sb);
    }
    
}
