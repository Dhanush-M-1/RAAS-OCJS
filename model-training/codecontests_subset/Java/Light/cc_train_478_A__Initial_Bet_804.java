import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        int sum = 0;
        for(int i = 0; i < 5; i++) {
           sum += cin.nextInt();
        }
        
        if(sum % 5 == 0) {
            if(sum == 0) {
                System.out.println(-1);
            } else {
                System.out.println(sum / 5);    
            }
        } else {
            System.out.println(-1);
        }
    }
}
