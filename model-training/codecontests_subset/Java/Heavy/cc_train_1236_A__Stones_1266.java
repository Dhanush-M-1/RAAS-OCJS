
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EgorPidr {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine());
        while (q-- > 0){
            String[] s = reader.readLine().split(" ");
            int a,b,c;
            int res = 0;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);
            while(b > 0 && c > 1){

                res+=3;
                b--;
                c-=2;
            }
            while(b > 1 && a > 0 ){
                res+=3;
                b-=2;
                a--;
            }
            System.out.println(res);
        }
    }

}
