import java.util.*;
 
 
public class test {
 
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in) ;
        int tc = in.nextInt();
        while(tc -- > 0){
            int n,m;
            String s;
            n = in.nextInt();
            m = in.nextInt();
            s = in.next();
            int[] p = new int[m];
            
            for(int i = 0;i < m;i++){
                p[i] = in.nextInt();
            }
            
            int[] d = new int[n + 1];
            
            for(int i = 0;i < m;i++){
                d[0]+= 1;
                d[p[i]]-=1;
            }
            
            for(int i = 1;i < n;i++){
                d[i]+=d[i - 1];
            }
            for(int i = 0;i < n;i++){
                 d[i]+=1;
            }
            
            int[] count = new int[26];
            for(int i = 0;i < n;i++){
                count[s.charAt(i) - 'a']+=d[i];
            }
            
            for(int i = 0;i < 26;i++){
                System.out.print(count[i] + " ");
            }
             System.out.println();
        }
        
    }

}