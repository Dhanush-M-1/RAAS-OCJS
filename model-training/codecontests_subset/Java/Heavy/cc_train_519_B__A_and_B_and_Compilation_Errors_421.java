import static java.lang.System.in;

import java.io.IOException;
import java.util.*;

public class B294 {
    
    static byte[] buffer = new byte[8192];
    static int offset = 0;
    static int bufferSize = 0;
    public static void main(String args[])throws IOException
    {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> m1 = new HashMap<Integer,Integer>();
        int n = readInt();
        int a1 =-1,a2=-1;
        for (int i=0;i<n;i++)
        {
            int num =  readInt();
            if (m.containsKey(num))
            {
                int f = m.get(num);
                m.put(num,f+1);
                m1.put(num,f+1);
            }
            else
                {
                m.put(num,1);
                m1.put(num,1);
                }
        }
        
        for (int i=0;i<n-1;i++)
        {
            int num =  readInt();
                int f = m.get(num);
                f--;
                if (f==0)
                    m.remove(num);
                else
                m.put(num,f);
            
            
            
        }
        for (int v : m.keySet())
            {
            a1=v;
            System.out.println(v);
            }
        for (int i=0;i<n-2;i++)
        {
            int num =  readInt();
                int f = m1.get(num);
                f--;
                if (f==0)
                    m1.remove(num);
                else
                m1.put(num,f);
            
            
            
        }
        if (m1.size()==1)
        {
            for (int v : m1.keySet())
            {
            System.out.println(v);
            }
        }
        else
        {
            m1.remove(a1);
            for (int v : m1.keySet())
            {
            System.out.println(v);
            }
        }
        
            
        
    } 
    
    
    static int readInt() throws IOException{
        int number = 0;
        int s =1;
        if(offset==bufferSize){
            offset = 0;
            bufferSize = in.read(buffer);
        }
        for(;buffer[offset]<0x30 || buffer[offset]=='-'; ++offset)
        {
            if (buffer[offset]=='-')
                s=-1;
            if(offset==bufferSize-1 ){
                offset=-1;
                bufferSize = in.read(buffer);
            }
        }
        for(;offset<bufferSize && buffer[offset]>0x2f;++offset){
            number = number*0x0a+buffer[offset]-0x30;
            if(offset==bufferSize-1){
                offset = -1;
                bufferSize = in.read(buffer);
            }
        }
        ++offset;
        return number*s;
    }

}
