import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        // input
        int num = scan.nextInt();
        int sum = 0;
        for(int i = 0; i < num; i++){
            sum += scan.nextInt() - 1;
        }

        // answer
        System.out.println(sum);

    }
}