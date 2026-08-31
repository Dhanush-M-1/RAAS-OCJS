import java.util.*;
import static java.lang.Math.*;

public class SolutionB {
       public static void main(String args[]){
              Scanner sc = new Scanner(System.in);
              int sum = 0;
              for(int i = 0; i < 5; i++)
                     sum += sc.nextInt();
              int ans = (sum % 5 != 0 || sum == 0) ? -1 : sum / 5;
              System.out.println(ans);
	}
}