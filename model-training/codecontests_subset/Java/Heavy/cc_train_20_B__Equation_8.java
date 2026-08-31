import java.math.BigDecimal;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        
        double A = sc.nextInt();
        double B = sc.nextInt();
        double C = sc.nextInt();
        
        if (A==0 && B!=0){System.out.println(1);System.out.println( new BigDecimal(-C/(B)).setScale(5, BigDecimal.ROUND_HALF_DOWN) );} else {
            
        if (B==0 && A==0 && C!=0){System.out.println(0);} else {    
            
        if (A==0 && B==0 && C==0){System.out.println(-1);}
        else 
        {           
            if (B*B-4*A*C<0){System.out.println(0);}
            else
            {
                
                if(B*B-4*A*C==0){System.out.println(1);System.out.println( new BigDecimal(-B/(2*A)).setScale(5, BigDecimal.ROUND_HALF_DOWN) );}
                
                else
                {
                    System.out.println(2);
                    BigDecimal[]W = new BigDecimal[2];
                    W[0] = new BigDecimal((-B - Math.sqrt(B*B-4*A*C))/(2*A)).setScale(5, BigDecimal.ROUND_HALF_DOWN);
                    W[1] = new BigDecimal((-B + Math.sqrt(B*B-4*A*C))/(2*A)).setScale(5, BigDecimal.ROUND_HALF_DOWN);
                
                    if (W[0].compareTo(W[1])==1){System.out.println(W[1]); System.out.println(W[0]);} else 
                    {System.out.println(W[0]);System.out.println(W[1]);}
                
                }
            }
            
        }
        }
        }
    }
}   