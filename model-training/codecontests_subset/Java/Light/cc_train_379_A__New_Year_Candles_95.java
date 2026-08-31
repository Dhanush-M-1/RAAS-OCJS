import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class stpar
{
    private static BufferedReader f;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();int b = sc.nextInt();
        int i= 0;
        while(a>0){
            a--;
            i++;
            if(i%b==0) a++;
        }
        System.out.println(i);
    }
}