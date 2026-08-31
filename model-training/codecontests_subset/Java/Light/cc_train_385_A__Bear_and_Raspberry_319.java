import java.util.*;
public class codetest {
    
    
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int[] days = new int[n];
        
        int cost = input.nextInt();
        
        int greatest = -9999999;
        for (int i = 0; i < days.length; i++) {
            days[i] = input.nextInt();
            if (i != 0 && days[i-1] - days[i] > greatest)
                greatest = days[i-1] - days[i];
        }
        if (greatest - cost < 0) {
            greatest = 0;
            cost = 0;
        }
        System.out.println(greatest - cost);
    }
}
