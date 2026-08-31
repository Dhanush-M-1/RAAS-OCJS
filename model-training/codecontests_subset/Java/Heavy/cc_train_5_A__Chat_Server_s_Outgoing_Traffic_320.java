import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ChatServersOutgoingTraffic {

    public static void main(String... args){
        HashSet<String> hs = new HashSet<String>();
        int summ=0, cnt=0;
        String str;
        
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            while ( (str=br.readLine())!=null && str.trim().length()>0 && cnt++<100) {
                if (str.startsWith("+")){
                    hs.add(str.substring(1));
                } else if (str.startsWith("-")) {
                    hs.remove(str.substring(1));
                } else{
                    str = str.substring(str.indexOf(":")+1);
                    summ += hs.size()*str.length();
                }
            }
            br.close();
            System.out.print(summ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}