
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

    static void sort(int a[])
    {
        Random ran = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = ran.nextInt(a.length);
            int temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }

        Arrays.sort(a);
    }
  
    public static void main(String[] args) throws IOException
    {

        Scanner input = new Scanner(System.in);
        int count=0;
        long ans =0;
       while(input.hasNextLine())
       {
           String s = input.nextLine();
           
           if(s.charAt(0)=='+')
               count++;
           else if(s.charAt(0)=='-')
           {
               count--;
           }else
           {
               int index = s.indexOf(":");
               ans+=(count*(s.length()-(index+1)));
           }
               
       }
        System.out.println(ans);
    }
    
   


}
