
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author rajee
 *
 */
public class CodeForces1374B {

    /**
    * 
    * Function name - main
    * Description   - 
    * @param     - 
    * @return        - void
    */
    public static void main(String[] args) { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        final int cases;
        try {
            cases = Integer.parseInt(br.readLine().trim());      
            
            for (int t = 1; t <= cases; t++) {
                
                int n = Integer.parseInt(br.readLine().trim());
                int steps = 0;
                while(n!=1) {
                    if(n%6 == 0) {
                        n = n/6;
                        steps++;
                    }else if( (n*2) % 6 == 0) {
                        n = n *2;
                        steps++;
                    }else {
                        steps = -1;
                        break;
                    }
                }
                System.out.println(steps);
            }
            
           
           

        } catch (IOException e) {
            
            e.printStackTrace();
        }
       
       
    }

}
