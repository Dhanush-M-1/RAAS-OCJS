



import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class Again {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user = 0 , t = 0;
        while( sc.hasNextLine())
        {
            String s = sc.nextLine();
            if(s.charAt(0) == '+')
                user++;
            else if(s.charAt(0) == '-')
                user--;
            else
            {
                t+= user*(s.length() - s.indexOf(':')-1);
            }
            
        }
        
        System.out.println(t);
    
}}