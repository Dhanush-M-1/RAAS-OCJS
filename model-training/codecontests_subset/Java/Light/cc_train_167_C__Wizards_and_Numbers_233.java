
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Phan
 */
public class p167c {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            long a = in.nextLong();
            long b = in.nextLong();
            System.out.println(check(Math.min(a, b), Math.max(a, b)) ? "First" : "Second");
        }
    }
    
    static boolean check(long a, long b) {
        if(a == 0 || b == 0) return false;
        if(!check(b%a, a)) return true;
        return ((b/a)%(a+1))%2 == 0;
    }
}
