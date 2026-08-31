import java.awt.image.SinglePixelPackedSampleModel;
import java.util.*;

public class practise {

    /*
     * Scanner scanner = new Scanner(System.in); int NCase = scanner.nextInt();
     * String Input = scanner.next();
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int total = 0 ; 
        for (int i= 0 ; i < 5 ; i ++){
        
            total += scanner.nextInt() ; 
        
        }
        if (total%5!=0 || total ==0){System.out.println(-1);}
        else {System.out.println(total/5);}
       
    }
}

