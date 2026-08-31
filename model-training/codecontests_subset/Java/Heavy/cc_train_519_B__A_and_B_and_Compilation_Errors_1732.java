import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        PrintWriter cout = new PrintWriter(new BufferedOutputStream(System.out));
        int n = cin.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++){
            res ^= cin.nextInt();
        }
        int tmp = res;
        for (int i = 0; i < n - 1; i++){
            res ^= cin.nextInt();
        }
        cout.println(res);
        for (int i = 0; i < n-2; i++){
            tmp ^= cin.nextInt();
        }
        cout.println(res ^ tmp);
        cout.flush();
    }

}
