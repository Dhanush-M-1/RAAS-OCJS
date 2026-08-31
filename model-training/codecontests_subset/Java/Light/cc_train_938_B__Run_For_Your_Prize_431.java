import java.util.Scanner;

public class App 
{
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
    
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
    public static void main( String[] args ) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int time = 0;
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            time = max(time, min(pos - 1, 1000000 - pos));
        }
        
        System.out.println(time);
    }
}
