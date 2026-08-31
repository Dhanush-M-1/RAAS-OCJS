import java.util.*;
public class code {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        if(s.length()%n==0)
        {
            int[] a=new int[26];
            for(int j=0;j<s.length();j++)
            {
                a[(int)s.charAt(j)-97]++;
            }
            int i=0;
            for(i=0;i<26;i++)
            {
                if(a[i]!=0)
                {
                    if(a[i]%n != 0)
                    {
                        System.out.println(-1);
                        break;
                    }
                }
                
            }
            String t="",ans="";
            if(i==26)
            {
                for(i=0;i<26;i++)
                {
                    t="";
                    for(int j=0;j<a[i]/n;j++)
                    {
                        t+=(char)(i+97);
                    }
                    ans+=t;
                }
                for(i=0;i<s.length()/ans.length();i++)
                {
                    System.out.print(ans);
                }
               
            }
           
        }

        else
        {
            System.out.println(-1);
        }
        
       

        }
    }

