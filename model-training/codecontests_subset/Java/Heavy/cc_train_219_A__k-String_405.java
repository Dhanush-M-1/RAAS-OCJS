
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.*;

    public class Main
    {



        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
          int n = input.nextInt();
          String s = input.next();
          int a[] = new int[26],b[] = new int[26];
            for (int i = 0; i < s.length(); i++) {
                a[s.charAt(i)-'a']++;
            }
           
            for (int i = 0; i < 26; i++) {
                if(a[i]>0&&a[i]%n!=0)
                {
                    System.out.println("-1");
                    return;
                }
                b[i] = a[i]/n;
                
            }
            String ans="";
            int i=0;
            while(ans.length()!=s.length())
            {
                if(i==26)
                    i=0;
                if(a[i]>0)
                {
                    int len = (b[i]);
                    a[i]-=len;
                    while(len-->0)
                    {
                        ans+=(char)('a'+i);
                    }
                    
                }
                i++;
            }
            System.out.println(ans);
        }


    }
