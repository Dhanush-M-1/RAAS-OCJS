import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Main4 {
    public static boolean f(String a, String b)
    {
        //System.out.println(a+" "+b);
        if ( a.equals(b)) return true;
        if ( a.length() % 2 == 1 )
        {
            return false;
        }
        String a1 = a.substring(0, a.length()/2);
        String a2 = a.substring(a.length()/2);
        String b1 = b.substring(0, b.length()/2);
        String b2 = b.substring(b.length()/2);
        return (f(a1, b2) && f(a2, b1)) || ( f(a1, b1) && f(a2,b2));    
    }
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("in");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line, lines[];
    String c,b;
    c = in.readLine();
    b = in.readLine();
    if ( f(c, b))System.out.println("YES");
    else System.out.println("NO");
}
}
