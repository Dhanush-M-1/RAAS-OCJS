
import java.util.*;

public class SerialKiller {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String [] ini = new String [2];
        for( int i = 0 ; i < 2 ; i++)
        {
            ini[i] = sc.next();
        }
        //System.out.println("=====================");
        System.out.println(ini[0]+" "+ini[1]);
        
        int n = sc.nextInt();
        for( int i = 0 ; i < n ; i++ )
        {
            int index = -1 ;
            String old = sc.next();
            String nw = sc.next();
            //System.out.println(old+" "+nw);
            for( int k = 0 ; k < 2 ; k++)
            {
                if( old.equals(ini[k]) )
                    index = k ;
            }
            ini[index] = nw ;
            System.out.println(ini[0]+" "+ini[1]);
        }
        
        
        
    }
    
    
}
