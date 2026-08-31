import java.util.*;
import java.io.*;

public class test {
    public static void main(String[]args)throws IOException {
     //   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
    //    StringTokenizer st = new StringTokenizer(in.readLine());

        Scanner bob = new Scanner(System.in);


        int N = bob.nextInt();
        bob.nextLine();

        String s = bob.nextLine();

        String fin = "";
        int counter = 0;
        
        for(int i=0; i<N-1; i++)
        {
            int x  = counter(s.substring(i,i+2), s);
            
            if(x>counter)
            {
                counter = x;
                fin = s.substring(i,i+2);
            }

        }
        System.out.println(fin);
        bob.close();
        
    }
    public static int counter (String n, String m)
    {
         int counter = 0;
         for(int i=0; i<m.length()-1; i++)
        {
           
            if(m.substring(i,i+2).equals(n))
            {
                counter++;
                
            }

        }
        
         return counter; 
    }
    
}
