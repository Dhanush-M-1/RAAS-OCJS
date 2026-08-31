import java.util.Scanner;

public class football {
    private int bitrate;
    private int bandwidth;
    private int total_time;
    public football(int a, int b, int c) {
        bitrate = a;
        bandwidth = b;
        total_time = c;

    }
    public long calc() {
        double wait = (bitrate*1.0/bandwidth-1) * total_time;
        if (wait < 0.5) {
            return 1;
        } 
        if ( Math.round(wait)*1.0/wait-1.0 < 0.0000001 && Math.round(wait)*1.0/wait-1.0 > -0.0000001) {
            return Math.round(wait);
        }
        else 
            return Math.round(wait+0.5);
    }
    public void out() {
        System.out.println("Bitrate is " + bitrate);
        System.out.println("Bandwidth is " + bandwidth);
        System.out.println("Total time is " + total_time);
        return;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if ( a < 1 || b < 1 || c > 1000 || a <= b) 
            return;
        football test = new football(a,b,c);
        //football test = new football(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        //test.out();
        System.out.println(test.calc());
        return;
    }
}