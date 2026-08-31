import java.util.Scanner;
public class ChessForThree{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        String out = "YES";
        int one = 1, two = 2, spect = 3;
        for(int i = 0; i < c; i++){
            int winner = sc.nextInt();
            if(winner == one){
                int temp = spect;
                spect = two;
                two = temp;
            }
            else if(winner == two){
                int temp = spect;
                spect = one;
                one = temp;
            }
            else{
                out = "NO";
                break;
            }
        }
        System.out.println(out);
    }
}