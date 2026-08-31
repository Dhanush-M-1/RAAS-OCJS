import java.util.Scanner;


public class B519 {

   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long a=0,b=0,c=0;
        
        for (int i = 0; i < n; i++) {
            a+=in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            b+=in.nextInt();
        }
        for (int i = 0; i < n-2; i++) {
            c+=in.nextInt();
        }
        System.out.println((a-b)+"\n"+(b-c));
    }
    
}
