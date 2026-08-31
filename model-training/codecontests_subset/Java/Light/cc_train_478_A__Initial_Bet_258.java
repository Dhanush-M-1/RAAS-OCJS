import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int b[] = new int[5];
        int sum = 0;
        for(int i=0; i<5; i++){
            b[i] = in.nextInt();
            sum += b[i];
        }
        
        if(sum%5 == 0 && sum/5 !=0 )
            System.out.println(sum/5);
        else
            System.out.println(-1);
    }
}