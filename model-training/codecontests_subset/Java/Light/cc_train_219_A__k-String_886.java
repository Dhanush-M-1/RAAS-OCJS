import java.util.*;
public class _2
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        in.nextLine();
        String str=in.nextLine();
        if(str.length()%k!=0)
            System.out.println("-1");
        else
        {
            int a[]=new int[26];
            //int b[]=new int[26];
            for(int i=0;i<str.length();i++)
            {
                a[str.charAt(i)-'a']++;
                //b[str.charAt(i)-'a']++;
            }
            
            //Arrays.sort(a);
            
            boolean check=false;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++)
            {
                if(a[i]%k!=0)
                {
                    System.out.println("-1");
                    check=true;
                    break;
                }
                else
                {
                    int temp=a[i]/k;
                    while(temp-->0)
                        sb.append((char)(i+'a'));
                }
            }
            if(!check){
               String str1=sb.toString(); 
            while(k-->1){
               sb.append(str1);
            }
            
            System.out.println(sb.toString());
            }
        }
    }
}