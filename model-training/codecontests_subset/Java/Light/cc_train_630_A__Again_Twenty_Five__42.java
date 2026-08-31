import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Shawon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
		BigInteger b,p,m;
                int i,n;
               // n=input.nextInt();
		
			b=BigInteger.valueOf(5);
			p=input.nextBigInteger();
			m=BigInteger.valueOf(100);
			
			System.out.println(b.modPow(p,m));    
                                
			
		
		
	}
        
    }
    

