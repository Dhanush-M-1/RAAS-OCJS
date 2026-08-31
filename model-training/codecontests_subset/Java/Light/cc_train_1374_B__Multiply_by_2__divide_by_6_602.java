 
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = scan.nextInt();
        for(int cnt = 0; cnt<counter; cnt++){
            int n = scan.nextInt();
            System.out.println(func(n));
        }
    }
    public static int func(int n){
        int i = 0;
        while(n!=1){
            if(n<=2){
                return -1;
            }
            if(n%6==0){
                n/=6;
            }
            else{
                n*=2;
            }
            i++;
        }
        return i;
    }
}