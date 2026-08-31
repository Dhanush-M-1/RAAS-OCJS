import java.io.*;
public class Good
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        String f="";
        if(n==1)
            System.out.println(1+"\n"+s);
        else
        {
            int count=0;
            int i=0;
            for(int x=n-1;x>=0;x--)
            {
                String str=s.substring(i,x+1);
                if(isGood(str)==true)
                {
                    i=x+1;
                    f=f+str;
                    count++;
                    if(i==n)
                    break;
                    f=f+" ";
                    x=n;
                }
            }
            System.out.println(count+"\n"+f);
        }
    }

    private static boolean isGood(String s)
    {
        int co=0,cz=0;
        for(int x=0;x<s.length();x++)
        {
            char ch=s.charAt(x);
            if((int)(ch-48)==1)
                co++;
            else
                cz++;
        }
        if(cz==co)
            return false;
        return true;
    }
}