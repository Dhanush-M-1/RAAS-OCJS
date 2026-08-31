import java.io.PrintWriter;
import java.util.Scanner;


public class A {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Mags mags = new Mags();
        mags.sol();
        mags.print();
    }

}

class Mags {

    Mags(){
        Scanner scr = new Scanner(System.in);
        n = scr.nextInt();
        x = scr.nextInt();
        y = scr.nextInt();
        scr.close();
    }
    
    void sol(){
        int tmp = (y * n)/100 - x;
        ans = tmp;
        if ((y*n) % 100 != 0){
            ans++;
        }
        if (ans < 0){
            ans = 0;
        }
    }
    
    void print() {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(ans);
        pw.flush();
        pw.close();
    }
    
    int ans;
    
    int n, x, y;
}

