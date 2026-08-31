import java.io.*;
public class Phone
{
    public static void main(String args[])
    throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s=new String(br.readLine());
        char[] ch=s.toCharArray();
        int num=0,rem=0,div=0,ans=0;
        for(int i=0;i<n;i++)
        {
            if(ch[i]=='8')
            {
                num=num+1;
            }
        }
        div=n/11;
        rem=n%11;
        if(div==num)
        {
            ans=num;
            }
            else if(div>num)
            {
                ans=num;
            }
            else if(div<num)
            {
            ans=div;
            }
            System.out.print(ans);
    }
}