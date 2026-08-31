import java.util.*;
import java.io.*;

public class TelephoneNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int lenght = Integer.parseInt(b.readLine());
        String cards = b.readLine();
        
        int max = lenght/11;
        int i = 0;
        int count = 0;
        while(i<lenght && count < max){
            if(cards.charAt(i++)== '8')
                count++;
        }
        System.out.println(count);
    }
    
}