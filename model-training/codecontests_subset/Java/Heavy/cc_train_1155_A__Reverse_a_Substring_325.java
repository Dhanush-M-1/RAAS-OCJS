import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Substring 
{
    
    
    public static void sub(String st)
    {
        char[] ar = st.toCharArray();
        
        for(int i=0; i<ar.length-1; ++i)
        {
            if(ar[i]>ar[i+1])
            {
                out.println("YES\n"+(i+1)+" "+(i+2));
                return;
            }
        }
        out.println("NO");
    }
    
    
    
   
    
    
    public static void main(String[] args) throws Exception
    {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.valueOf(b.readLine());
        String s = b.readLine();
        sub(s);
    }
}
