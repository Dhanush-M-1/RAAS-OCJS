import java.util.*;
 
public class Sol{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = a^b;
            int f[] = {a,b,c};
            int n = in.nextInt();
            System.out.println(f[n%3]);
        }
    }
}