import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class JavaApplication141 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
          
	      int t= in.nextInt();
              
               while(t-->0){  
            int n=in.nextInt();
            
            long min = 1000000000;  int max = 0;
            
            for (int i=0; i<n ;i++) {
                
                int x = in.nextInt() ; 
                max = Math.max(max, x); //4
                
                int y = in.nextInt() ; 
                min = Math.min(min,y ); //0
            } 
            
            System.out.println(Math.max(max-min,0));
        }}}    
          
          