import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
public class MarvoloRing {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String inp = kbd.nextLine();
        String[] input = inp.split(" ");
        long inpAx = Long.parseLong(input[0]) * 2;
        long inpAy = Long.parseLong(input[1]) * 2;
        long inpBx = Long.parseLong(input[2]) * 2;
        long inpBy = Long.parseLong(input[3]) * 2;
        long inpCx = Long.parseLong(input[4]) * 2;
        long inpCy = Long.parseLong(input[5]) * 2;
        
        long n = (Math.abs(inpAx - inpBx) * Math.abs(inpAx - inpBx)) + (Math.abs(inpAy - inpBy) * Math.abs(inpAy - inpBy));
        long m = (Math.abs(inpBx - inpCx) * Math.abs(inpBx - inpCx)) + (Math.abs(inpBy - inpCy) * Math.abs(inpBy - inpCy));
        long i = (inpAx + inpCx) / 2;
        long j = (inpAy + inpCy) / 2;
        
        if(n == m && !(i == inpBx && j == inpBy)){
        	System.out.println("YES");
        } else{
        	System.out.println("NO");
        }
    }
}
