import java.util.Scanner;

public class chess{
    public static void main(String[]arga){
        int spectator=3;
        boolean valid = true;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            int winner = sc.nextInt();
            if(winner==spectator){
                valid=false;
                break;
            }else{
                spectator=6-spectator-winner;
            }
        }
        System.out.println(valid ? "YES" : "NO");
    }
}