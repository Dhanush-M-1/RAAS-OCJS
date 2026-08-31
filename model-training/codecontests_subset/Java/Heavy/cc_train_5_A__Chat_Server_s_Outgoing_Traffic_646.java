import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatServersOutgoingTraffic {

    public static void main(String... args) throws IOException{
        int summ=0, cnt=0;
        String str;
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
            
        while ( (str=br.readLine())!=null && str.trim().length()>0) {
            if (str.startsWith("+"))
                cnt++;
            else if (str.startsWith("-"))
                cnt--;
            else
                summ += cnt*str.substring(str.indexOf(":")+1).length();
        }
        br.close();
        System.out.print(summ);
    }
}