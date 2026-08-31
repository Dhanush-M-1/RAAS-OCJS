
// Imports
import java.util.*;
import java.io.*;

public class D {

    /**
     * @param args the command line arguments
     * @throws IOException, FileNotFoundException 
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        
        long[][] leafbushes = new long[2000000][3];
        long MOD = (long)1E9 + 7;
        leafbushes[0][0] = 1;
        for(int i = 1; i < 2000000; i++) {
            leafbushes[i][0] = (leafbushes[i - 1][0]%MOD + 2*leafbushes[i - 1][1]%MOD)%MOD;
            leafbushes[i][1] = leafbushes[i - 1][0]%MOD;
            leafbushes[i][2] = leafbushes[i - 1][1]%MOD;
            
            if(i > 2) {
                leafbushes[i][2] += leafbushes[i - 3][2]%MOD;
                leafbushes[i][2] %= MOD;
            }
        }
        
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(f.readLine());
            
            System.out.println((leafbushes[N - 1][2]*4)%MOD);
        }
        
        
        // System.out.println(Arrays.deepToString(leafbushes));
    }

}
