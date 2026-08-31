import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int k = scan.nextInt();
        int accSum = 0;
        int num = 1;
        
        int[] robotId = new int[n];
        for(int i = 0; i < n; i++){
            robotId[i] = scan.nextInt();
        }
        while(k > accSum) {
            accSum += num;
            if(accSum >= k) {
                accSum -= num;
                break;
            }
            num++;
        }
        System.out.println(robotId[k - accSum - 1]);
    }
}
