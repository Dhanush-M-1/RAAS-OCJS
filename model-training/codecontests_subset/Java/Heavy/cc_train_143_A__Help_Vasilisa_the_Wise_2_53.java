
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tok;
        tok = new StringTokenizer(r.readLine());
        int r1 = parseInt(tok.nextToken());
        int r2 = parseInt(tok.nextToken());
        tok = new StringTokenizer(r.readLine());
        int c1 = parseInt(tok.nextToken());
        int c2 = parseInt(tok.nextToken());
        tok = new StringTokenizer(r.readLine());
        int d1 = parseInt(tok.nextToken());
        int d2 = parseInt(tok.nextToken());
        
      
        

           int d=(c2+r2-d2)/2;
		int a=d1-d;
		int c=r2-d;
		int b=d2-c;
           if(a<1||a>9||b<1||b>9||c<1||c>9||d<1||d>9||a==b||a==c||a==d||b==c||b==d||c==d||a+b!=r1||c+d!=r2||a+c!=c1||b+d!=c2||a+d!=d1||b+c!=d2) {
              
            System.out.println(-1);

           

        }
      else {
            System.out.println(a + " " + b);
            System.out.println(c + " " + d);
        
        }

    }

}
