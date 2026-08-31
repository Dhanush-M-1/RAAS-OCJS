import static java.lang.System.in;

import java.io.IOException;
import java.util.*;

public class C_GoodBye {

    static byte[] buffer = new byte[8192];
    static int offset = 0;
    static int bufferSize = 0;
    public static void main(String args[])throws IOException
    {
        int n = readInt();
        int m =readInt();
        int w[]= new int[n];
        int f[]= new int[m];
        int v[]= new int[n];
        ArrayList<Integer> st = new ArrayList<Integer>();
        ArrayList<Integer> st2 = new ArrayList<Integer>();
        int ans =0;
        for(int i=0;i<n;i++)
            w[i]=readInt();
        for (int i=0;i<m;i++)
            f[i]= readInt()-1;
        int c =0;
        int j=0;
        while(c!=n && j<m)
        {
            if (v[f[j]]==0)
            {
                st.add(f[j]);
                c++;
                v[f[j]]=1;
                
            }
            j++;
            
        }
        for (int i=st.size()-1;i>=0;i--)
            {
            st2.add(st.get(i));
            
            }
        //System.out.println(st2);
        for (int i=0;i<m;i++)
        {
            
            for (j=0;j<st2.size();j++)
            {
                if (st2.get(j)==f[i])
                {
                  
                  break;
                }
            }
        //  System.out.println(st2 +" "+ f[i] +" "+j);
            for (int k=j+1;k<st2.size();k++)
                ans +=w[st2.get(k)];
        //  System.out.println(ans);
            st2.remove(j);
            st2.add(f[i]);
        }
        System.out.println(ans);
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
