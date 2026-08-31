import java.io.*;
public class a5
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        String s;
        int l,i=0,j=0,k=0;
        while(in.ready()==true)
        {
            s=in.readLine();
            if(s.charAt(0)=='+')
            j++;
            else if(s.charAt(0)=='-')
            j--;
            else
            {
                l=s.length();
                l--;
                k=s.indexOf(':');
                i=i+j*(l-k);
            }
        }
        System.out.println(i);
    }
}

                    