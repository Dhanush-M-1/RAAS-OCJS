import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author win7
 */
public class Lifecodechef{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws java.lang.Exception{
        // TODO code application logic here
           Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        input.nextLine();
        String s = input.nextLine();
        if(k==1){
            System.out.println(s);
            return;
        }
        
        char[] a = s.toCharArray();
        Arrays.sort(a);
        s = String.valueOf(a);
        int end = 0;
        String pair = "";
        for(int i=0;i<s.length();i++){
            end  = s.lastIndexOf(String.valueOf(s.charAt(i)));
            if((end-i+1) % k ==0){
                pair+= s.substring(i, i+(int)Math.ceil((end-i+1)/k));
                i = end;
            }
            else{
                System.out.println(-1);
                return;
            }
             
         }
        String result = pair;
        for(int i = 1;i<k;i++){
            result+= pair;
        }
        System.out.println(result);
    }
}