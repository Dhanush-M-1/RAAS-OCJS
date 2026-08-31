import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0)
        {
            StringBuilder ans = new StringBuilder();
            String str = s.next();
            
         
            int i=1;
            int c=0;
            int n = str.length();
            if(n==1) {
                System.out.println(0);
                continue;
            }
            
            boolean vis[] = new boolean[n];
            
            while(i<n)
            {
                
                if(i>1)
                {
                    if(!vis[i-2] && str.charAt(i-2)==str.charAt(i))
                    {
                        c++;
                        vis[i] = true;
                    }
                }
                
                if(!vis[i-1])
                {
                    if(str.charAt(i-1) == str.charAt(i))
                    {
                        c++;
                       
                         vis[i] = true;
                    }
                }
                
                //System.out.println(i+" "+c+" ");
                
                i++;
            }
        
            
            System.out.println(c);

        }
     
    }
}