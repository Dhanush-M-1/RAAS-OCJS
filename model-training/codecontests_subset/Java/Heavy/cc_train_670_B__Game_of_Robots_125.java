import java.util.Scanner;

/**
 *
 * @author Zeref
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),k=in.nextInt(),fact=0,pos=0;
        int []array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            fact+=i;
            if(k<=fact){
                pos=i;
                break;
            }
        }
        System.out.println(array[pos-1-(fact-k)]);
        
            
                    
    }
    
}
