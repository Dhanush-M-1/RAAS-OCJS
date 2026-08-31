import java.util.*;
public class AgainTwentyFive {
        

    public AgainTwentyFive() {
    }
    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        double num = kbd.nextDouble();
        long ans = (long) Math.pow(5, num);
        long finalAns = ans%100;
        
        if (ans<=22){
        	System.out.println(finalAns);
        }else{
        	System.out.println("25");
        }
        
    }
}
