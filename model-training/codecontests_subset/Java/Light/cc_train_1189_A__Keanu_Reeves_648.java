


import java.util.*;


/**
 *
 * @author Mahmoud
 */
public class Code {

    /**
     * 
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
       
        Scanner sc =new Scanner(System.in);
        
        int x =sc.nextInt();
        String y =sc.next();
        
        int ze=0,one=0;
        
        for(int i =0 ;i< y.length(); i++)
        {
         if(y.charAt(i) == '0') ze++;
         else
             one++;
             
        }
       
        System.out.println((ze == one)? "2\n"+y.substring(0, y.length()-1)+" "+y.charAt(y.length()-1):"1\n"+y);
}
}