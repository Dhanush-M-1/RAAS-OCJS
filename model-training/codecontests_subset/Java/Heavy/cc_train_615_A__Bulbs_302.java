

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C338_A {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr  = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        String [] s = br.readLine().trim().split(" ");
        
        int n = Integer.valueOf(s[0].trim());
        int m = Integer.valueOf(s[1].trim());
        
        int [] ar = new int [m];
        
        
        for(int i=0;i<n;i++){
            String [] s1 = br.readLine().trim().split(" ");
            
            int sz = Integer.valueOf(s1[0].trim());
            for(int j=0;j<sz;j++){
                ar[Integer.valueOf(s1[j+1].trim())-1]=1;
            }
        }
        boolean y = true;
        for(int i=0;i<m;i++){
            if(ar[i]==0){
                y = false;
                break;
            }
        }
        if(y)
            System.out.println("YES");
        else
            System.out.println("NO");
        
        

    }

}
