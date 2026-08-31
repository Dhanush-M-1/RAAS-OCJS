
import java.util.Scanner;

public class Ladder {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt=0;
        int c100=0;
        int c200=0;
        for (int i = 0; i < n; i++) {
            if(scanner.nextInt()==100){
                cnt++; c100++;
            }
            else{
                cnt+=2;
                c200++;
            }
        }
        
        if(c200%2==1 && c100==0){
            System.out.println("NO");
        }else{
            System.out.println((cnt%2==0&&n>1)?"YES":"NO");
        }
    }
}
