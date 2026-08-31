import java.io.*;
public class Killer
{
    public static void main(String args[])
    throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        int n=Integer.parseInt(br.readLine());
        String[] s2=new String[n];
        for(int i=0;i<n;i++)
        {
            s2[i]=br.readLine();
        }
        System.out.println(s1);
        for(int i=0;i<n;i++)
        {
            String[] s4=s2[i].split(" ");
            String[] s3=s1.split(" ");
            if(s4[0].equals(s3[0]))
            {
                s3[0]=s4[1];
                }
                else if(s4[0].equals(s3[1]))
                {
                    s3[1]=s4[1];
                }
                s1=s3[0].concat(" "+s3[1]);
                System.out.println(s1);
        }
    }
}