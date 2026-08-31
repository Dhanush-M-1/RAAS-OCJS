import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Super{
   
    public static void main(String[] args) throws IOException{
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ww = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] str = s.readLine().split(" ");
        double a = Double.parseDouble(str[0]); 
        int b = Integer.parseInt(str[1]); double c = Double.parseDouble(str[2]);
        int req = (int)Math.ceil((c/100)*a);
        if(req >= b)
            ww.println(req-b);
        else
            ww.println(0);
        ww.close();
    }
}