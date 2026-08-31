
import java.util.*;

public class HelpfulMaths {


    public static void main(String[] args) {
        String str;
        char chr;
        int c1=0, c2=0, c3=0;
        int sum, sum1, c = 0;
        int[] math = new int[50];
        
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        
        for(int i=0; i<str.length(); i+=2){
            chr = str.charAt(i);
            if (chr == '1'){
                math[c]=1;
                c1++;
            }
            else if(chr == '2'){
                math[c]=2;
                c2++;
            }
            else if(chr == '3'){
                math[c]=3;
                c3++;
            }
            c++;
        }
        sum = c1+c2+c3;
        sum1 = math.length - sum;
        Arrays.sort(math);
        
        for(int i=sum1; i<math.length; i++){
            System.out.print(math[i]);
            if (i < (math.length-1)){
                System.out.print('+');
            }
            
            
        }
        
    }
    
}
