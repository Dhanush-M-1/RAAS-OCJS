import java.util.*;
import java.io.*;

public class A385 {

    public static int I(String s){
        Integer i = new Integer(s);
        return i.intValue();
    }

    public static void main(String args[]) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] line = r.readLine().split("\\s+");
        int n = I(line[0]);
        int c = I(line[1]);
        line = r.readLine().split("\\s+");
        ArrayList<Integer> x = new ArrayList<Integer>();
        for(String s : line){
            x.add(I(s));
        }
        int max = -1;
        for(int i = 0; i < n-1; i++){
            if(x.get(i)-x.get(i+1) > max){
                max = x.get(i) - x.get(i+1);
            }
        }
        if(max-c < 0){
            System.out.println(0);
            return;
        }
        System.out.println(max-c);

    }
}
