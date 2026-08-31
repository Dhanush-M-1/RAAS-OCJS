import java.util.Scanner;

public class Initial_Bet{   
    public static void main(String args[]){
            Scanner in = new Scanner(System.in);
            int sum = 0 ;
            for(int i = 0 ; i <  5 ; i++){
                int temp = in.nextInt();
                sum+= temp;
            }
            if(sum%5==0&&sum!=0){
                System.out.println(sum/5);
            }else{
                System.out.println(-1);
            }

    }
}