import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpfulMaths {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String [] line=s.split("\\+");
        int l=line.length;
     
        Arrays.sort(line);
       
        System.out.print(line[0]);
        for(int i=1;i<l;i++)
        {
            System.out.print("+"+line[i]);
        }
    }
    
}