/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class S {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		InputReader reader = new InputReader(System.in);
        //OutputWriter out = new OutputWriter(System.out);
        
        int z=0,count=0;
        try {
            String k = reader.readLine();
            while(k != null)
            {
                if(k.charAt(0)=='+')
                {
                    count++;
                }
                else if(k.charAt(0)=='-')
                {
                    
                    count--;
                }
                else
                {
                    String sa[]=k.split(":");
                    int l=0;
                    if(sa.length==2)
                    {
                        l=sa[1].length();
                    }
                    
                    
                    
                    z=z+l*count;
                    
                    
                }
                k = reader.readLine();
            }
            
            System.out.println(z);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
	}
}
class InputReader extends BufferedReader {
    public InputReader(InputStream in) {
        super(new InputStreamReader(in));
    }
}