import java.util.Scanner;

/**
 *
 * @author User
 */
public class CodeForces1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int total=n;
        
       
            while(n>=m){
                total+=n/m;
                if(n%m==0)n=n/m;
                else n=n/m+n%m;
                
            }
        System.out.println(total);
        
    }
    
}
