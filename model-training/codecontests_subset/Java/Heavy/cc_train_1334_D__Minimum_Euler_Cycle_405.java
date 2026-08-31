
// Imports
import java.util.*;
import java.io.*;

public class D {

    /**
     * @param args the command line arguments
     * @throws IOException, FileNotFoundException 
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        // TODO UNCOMMENT WHEN ALGORITHM CORRECT
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        
        /* BufferedReader f = new BufferedReader(new StringReader("3\n" +
"2 1 3\n" +
"3 3 6\n" +
"99995 9998900031 9998900031")); */
        
        // TODO code application logic here
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            
            int tempN = N - 1;
            long count = 1;
            int actual = 0;
            
            while(count < L && tempN > 0) {
                count += 2*tempN;
                tempN--;
            }
            // System.out.println("COUNT: " + count);
            // System.out.println(tempN);
            
            if(tempN == 0 && count == L) {
                System.out.println("1");
            }
            else {
                actual = N - tempN - 1;
                if(count == 1) {
                    actual++;
                }
                else {                
                    count -= 2*(tempN + 1);
                }
                
                // System.out.println("ACTUAL: " + actual);
                // System.out.println("COUNT: " + count);
                
                StringBuilder sb = new StringBuilder();
                int x = actual;
                int y = actual + 1;
                
                while(count <= R) {
                    // count
                    if(count >= L) {
                        // System.out.println("xy: " + x + " " + y);
                        if(count % 2 == 1) {
                            sb.append(x);
                            sb.append(" ");
                        }
                        else {
                            sb.append(y);
                            sb.append(" ");
                        }
                    }
                    
                    if(count % 2 == 0) {
                        if(y < N) {
                            y++;
                        }
                        else if(x < N - 1) {
                            x++;
                            y = x + 1;
                        }
                        else {
                            x = 1;
                        }
                    }
                    
                    count++;
                }
                
                System.out.println(sb.substring(0, sb.length() - 1));
            }
            
        }
    }

}
