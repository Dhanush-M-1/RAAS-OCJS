import java.io.*;                                                                                                                                
public class Main                                                                                                                                                                                           
{
    public static void main(String[] args)throws IOException                                                                                      
    {
        BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(k.readLine());
        String str=(k.readLine());
        int freq[]=new int [26];
        for(int i=0;i<str.length();i++)
            freq[str.charAt(i)-'a']++;
        String ks="";
        boolean is=true;
        for(int i=0;i<26;i++)
        {
            if(freq[i]%n==0)
            {
                for(int j=0;j<freq[i]/n;j++)
                    ks=ks+(char)(i+'a');
            }    
            else
            {
                is=false;
                System.out.println(-1);
                break;
            }
        }
        if(is==true)
        {
            for(int i=0;i<n;i++)
                System.out.print(ks);
        }
    }    
}