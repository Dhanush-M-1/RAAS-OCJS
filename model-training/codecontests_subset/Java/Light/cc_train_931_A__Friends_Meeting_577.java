
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a,b,temp,ris = 0;
        a = scanner.nextInt();
        b = scanner.nextInt();
        
       temp = Math.max(a, b) - Math.min(a, b);
       
       if (temp % 2 != 0)
           ris += ((temp/2)+1);
       
       temp = temp/2;
       
       ris += temp * (temp+1);
       
       
       System.out.println(ris);
    }
}
