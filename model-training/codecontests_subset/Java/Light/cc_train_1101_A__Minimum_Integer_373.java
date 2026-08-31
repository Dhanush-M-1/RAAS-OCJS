import java.util.Scanner;
public class MyClass {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0;i<n;i++){
            int l = scan.nextInt();
            int r = scan.nextInt();
            int d = scan.nextInt();
            int res = d<l?d: r+(d-r%d);
            System.out.println(res);
        }
    }
}