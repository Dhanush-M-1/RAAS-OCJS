
import java.util.Scanner;
import java.util.StringTokenizer;
public class Candles {

    public static void main (String[]args) throws java.lang.Exception {
    	Scanner sc = new Scanner(System.in);
    	StringTokenizer st = new StringTokenizer (sc.nextLine());
    	int n= Integer.parseInt(st.nextToken());
    	int hours = n;
    	int x = Integer.parseInt(st.nextToken());
    	while (n/x > 0){
    		hours += n/x;
    		n= n/x + n%x;
    	}
    System.out.print(hours);
    }


}