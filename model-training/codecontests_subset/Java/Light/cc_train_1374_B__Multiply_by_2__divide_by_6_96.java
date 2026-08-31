import java.util.*;

public class Solve {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            long n = scan.nextLong();
            int count = 0;
            boolean f = true;
            while(n>1){
                if(n%3!=0){
                    f = false;
                    break;
                }
                else if(n%6==0){
                    n/=6;
                }
                else{
                    n*=2;
                }
                count++;
            }
            System.out.println(f?count:-1);
        }
    }
}