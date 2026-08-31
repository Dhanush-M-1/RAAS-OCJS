import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author aditya
 */
public class HelpfulMAths {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String st[] = s.split("[+]");
        Arrays.sort(st);
        String res="";
        for(String i:st){
            res=res+i+"+";
        }
        System.out.println(res.substring(0, res.length()-1));
    }
}
