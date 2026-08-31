import java.util.*;
import java.io.*;

public class Olimp {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int x=in.nextInt();
        int y=in.nextInt();
        int pr=(int)Math.ceil((double)n*y/100);
        System.out.println(Math.max(0, pr-x));
    }
}