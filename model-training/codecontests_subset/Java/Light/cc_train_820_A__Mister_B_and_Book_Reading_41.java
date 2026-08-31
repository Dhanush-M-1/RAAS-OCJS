
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;
import javafx.util.Pair;

public class Main
{

    public static void main(String[] args) throws IOException
    {

        Scanner input = new Scanner(System.in);
        int c,v0,v1,a,l;
        c = input.nextInt();
        v0 = input.nextInt();
        v1 = input.nextInt();
        a = input.nextInt();
        l = input.nextInt();
        int read=0,count=0;
        while(read<c)
        {
            count++;
            
            if(read==0)
            {
                read+=(v0);
                
            }else
            {
               read+=Math.min(v1, v0+(count-1)*a)-l;
            }
            
        }
        System.out.println(count);
    }

}
