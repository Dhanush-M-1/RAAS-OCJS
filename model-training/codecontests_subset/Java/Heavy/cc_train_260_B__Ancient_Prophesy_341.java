
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.String.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int [] nm = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        String str = in.readLine(),ans = "", date;
        int i,d,m,y,mx = 0,f;
        
        Map<String,Integer> freq = new HashMap<String,Integer>();
        
        for(y=2013; y<=2015; y++) {
            for(m=1; m<=12; m++) {
                for(d=1; d<=nm[m]; d++) {
                    date = format("%02d-%02d-%04d", d, m, y);
                    f = (str.length()-str.replace(date, "").length())/10;
                    freq.put(date, f);
                    if(freq.get(date)>mx) {
                        mx = freq.get(date);
                        ans = date;
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
    
}
