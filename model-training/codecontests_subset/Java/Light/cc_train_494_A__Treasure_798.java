import java.io.*;
import java.util.*;

public class C495C {
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    static Vector<Integer> ans = new Vector();
    
    public static void main(String[] args)throws IOException {
        
        char s[] = in.readLine().toCharArray();
        
        int i , j , n = s.length , a = 0, b = 0 , last = 0;
        
        for(i = 0;i < n;i ++)if(s[i] == '#')last = i;
        
        for(i = 0;i < n;i ++){
            if( s[i] == '(' )a ++;
            else
                if( s[i] == ')' )b ++;
            
            if(s[i] == '#' && i != last){
                b ++; ans.add(1);
            }
            
            if(s[i] == '#' && i == last){
                int a1 = 0 , b1 = 0;
                
                for(j = i + 1;j < n;j ++)
                    if(s[j] == '(')a1 ++;
                    else
                        b1 ++;
                
                if(a + a1 <= b + b1){
                    System.out.println(-1);
                    return;
                }
                
                ans.add(a + a1 - b1 - b);
                
                b = a + a1 - b1;
                
            }
            
            if(b > a){
                System.out.println(-1);
                return;
            }
            
        }
        
        for(int u:ans)
            System.out.println(u);
        

    }

}