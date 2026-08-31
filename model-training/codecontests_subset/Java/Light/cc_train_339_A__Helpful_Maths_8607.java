import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nay743
 * Oct 16, 2013-6:45:31 PM
 *
 **/
public class Main {
    public static void solve() {
        Scanner in = new Scanner(System.in);
        String sum=in.next();
        int len=sum.length();
        
        
        if(len==1){
            System.out.println(sum);
        }
        else{
            char[] numbers=sum.replaceAll("\\+", "").toCharArray();
            
            Arrays.sort(numbers);   
            String xeniaSum="";
            
            for (char c : numbers) {
                xeniaSum+=c+"+";
            }

            System.out.println(xeniaSum.substring(0, len));
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
