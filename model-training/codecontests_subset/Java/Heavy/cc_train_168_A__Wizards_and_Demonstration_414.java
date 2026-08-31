
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForces{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));    
    //static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer token;        
    public static void main(String args[])throws Exception{        
        token = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(token.nextToken());
        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());        
        int butuh = (int)Math.ceil(n*y/100.0);
        butuh = (butuh < x)?0:butuh - x;
        System.out.println(butuh);
    }   
    
}
