
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF615A {
    public static void main(String[] args) throws FileNotFoundException,IOException {
    //     BufferedReader input = new BufferedReader(new FileReader("input.txt"));  
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));          
        String s[] = input.readLine().split(" ");   
        int  n = Integer.parseInt(s[0]); //number of button
        int  m = Integer.parseInt(s[1]); //number of bulbs
        boolean lights[] = new boolean[m+1];
        int bulbs;
        boolean allOn = true;
        
        for (int i = 0; i < n; i++) {
            s = input.readLine().split(" ");  
            bulbs = Integer.parseInt(s[0]);;
            for (int j = 1; j <= bulbs; j++) {
                lights[Integer.parseInt(s[j])] = true;
            }      
       }
        for (int i = 1; i < lights.length; i++) {
           // System.out.println(lights[i]);      

             if(!lights[i]){ //if False
                 allOn = false;
                 break;
             }               
        }
      
	System.out.println(allOn ? "YES" : "NO");      
    }   
}