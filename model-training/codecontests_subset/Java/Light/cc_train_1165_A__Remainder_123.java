import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       int x = scanner.nextInt();
       int y = scanner.nextInt();
       String str = scanner.next();
       int coun = 0;
       for(int i = n-1; i >= str.length()-x; i--){
           if(i == (n-y-1)){
               if(str.charAt(i) == '0')
                   coun++;
           }
           else if(str.charAt(i) == '1')
               coun++;
           
       }
       System.out.println(coun);


    }
}
