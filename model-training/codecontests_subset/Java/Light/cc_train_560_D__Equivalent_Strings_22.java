import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main ( String[]args ) throws Exception
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        boolean x = check(a,b);
        if ( x)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
    
    
    public static boolean check ( String a , String b)
    {
        if (a.equals(b))
            return true;
        else if ( a.length() == 0 || a.length()%2!=0 )
            return false;
        else
        {
            String x = a.substring(0, a.length()/2);
            String y = a.substring(a.length()/2);
            String p = b.substring(0, b.length()/2);
            String q = b.substring(b.length()/2);
            
            
            if ( check(x, q))
            {
                if ( check(y, p))
                    return true;
            }
            if ( check(x, p) )
            {
                if ( check(y, q) )
                    return true;
            }
            return false;   
        }
    }
}
