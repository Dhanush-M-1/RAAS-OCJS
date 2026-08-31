import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        Vector<String> online=new Vector<String>();
        
        long traffic=0;
        while (in.ready())
        {
            String cur=in.readLine();
            if (cur.charAt(0)=='+') online.add(cur.substring(1));
            else if (cur.charAt(0)=='-') online.remove(cur.substring(1));
            else 
            {
                String[] message=cur.split(":");
                if (message.length>1) traffic+=message[1].length()*online.size();
            }
        }
        out.print(traffic);
        out.close();
    }

}
