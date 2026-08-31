import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class f{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        String[] s = new String[4];
        try{
        s = in.split("\\+");
        }
        catch(Exception e){
            System.out.println(in);
            return ;
        }
        
        java.util.Arrays.sort(s);
        System.out.print(s[0]);
        for(int i=1;i<s.length;i++){
            System.out.print("+"+s[i]);
        }

    }
}