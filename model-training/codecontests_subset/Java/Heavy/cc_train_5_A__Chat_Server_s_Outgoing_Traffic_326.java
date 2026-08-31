import java.io.*;
import java.util.*;
public class ChatServersOutgoingTraffic{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int n = 0 ; int l = 0 ;
        while(br.ready()){
            String w = br.readLine();
            if (w.charAt(0) == '+'){
                ++n;
            }else if (w.charAt(0) == '-')
                --n;
            else {
                int k = 0;
                for (int i = 0 ;i<w.length();i++){
                    if (w.charAt(i) == ':') break;
                    ++k;
                }
                String s = w.substring(k+1);
                l+= s.length()*n;
            }
        }
        out.print(l);
        out.flush();
    }
}