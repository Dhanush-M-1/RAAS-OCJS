import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Kareem
 *
 */
public class CharServers {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int count = 0, ans = 0;
        while((str = in.readLine()) != null) {
            if(str.contains("+")) count ++;
            else if(str.contains("-")) count--;
            else if(str.contains(":")) {
                String[] s = str.split(":");
                if(s.length > 1)
                    ans += (count * s[1].length());
            }
        }
        System.out.println(ans);
    }

}
