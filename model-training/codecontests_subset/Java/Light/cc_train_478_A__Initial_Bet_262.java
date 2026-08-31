import java.util.Scanner;
public class AInitialBet {

    
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int x, total=0;
        for(int i=0;i<5;i++)
        {
            x = input.nextInt();
            total+=x;
        }
        if(total%5==0 && total!=0)
            System.out.println(total/5);
        else
            System.out.println(-1);
    }
    
}