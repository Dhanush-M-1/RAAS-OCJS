import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        while(t-->0){
            int s=0;
            line = br.readLine();
            String[] values = line.split(" ");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            int c = Integer.parseInt(values[2]);
            while(c>1 && b>0){
                c=c-2;
                b--;
                s+=3;
            }
            while(b>1 && a>0){
                b=b-2;
                a--;
                s+=3;
            }
            System.out.println(s);
        }
    }
}
