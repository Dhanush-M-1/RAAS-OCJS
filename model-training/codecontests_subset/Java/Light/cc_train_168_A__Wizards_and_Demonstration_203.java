import java.io.*;
import java.util.*;
public class A168 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int clones = 0;
        String[] NXY = br.readLine().split(" ");
        int n = Integer.parseInt(NXY[0]);
        int x = Integer.parseInt(NXY[1]);
        int y = Integer.parseInt(NXY[2]);
        clones = (int)Math.ceil((y*n)/100.0 - x);
        if(clones>=0)
            System.out.println(clones);
        else
            System.out.println(0);
    }
}
