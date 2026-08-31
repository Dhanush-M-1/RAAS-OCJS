import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * AOJ0074 Videotape
 */
public class Main {
    public static void main(String... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] in = line.split(" ");
            int hh = Integer.parseInt(in[0]);
            int mm = Integer.parseInt(in[1]);
            int ss = Integer.parseInt(in[2]);
            if(hh<0)break;
            int rem = 2*60*60-(hh*60*60+mm*60+ss);
            System.out.println(format(rem));
            System.out.println(format(rem*3));
        }
    }

    static String format(int x){
        return String.format("%1$02d:%2$02d:%3$02d",x/3600,(x%3600)/60,x%60);
    }

}