import java.util.*;
import java.io.*;

public final class Main {

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long ax = Long.parseLong(st.nextToken());
        long ay = Long.parseLong(st.nextToken());
        long bx = Long.parseLong(st.nextToken());
        long by = Long.parseLong(st.nextToken());
        long cx = Long.parseLong(st.nextToken());
        long cy = Long.parseLong(st.nextToken());

        if(ax == bx && bx == cx || ay == by && by == cy){
            System.out.println("No");
            return;
        }

        long distAToB = ((long)Math.pow(Math.abs(ax-bx) ,2) + (long)Math.pow(Math.abs(ay-by), 2));
        long distBToC = ((long)Math.pow(Math.abs(cx-bx) ,2) + (long)Math.pow(Math.abs(cy-by), 2));
        if( distAToB != distBToC){
            System.out.println("No");
            return;
        }
        //distance from a to b must be same as b to c but they cannot all lie on the same plane
        //ie the slope from a to b and b to c cannot be equal
        if((ax-bx) == 0 && (bx-cx) == 0){
            System.out.println("No");
            return;
        }else if((ax-bx) == 0 || (bx-cx) == 0){
            System.out.println("Yes");
            return;
        }
        double aToBSlope = (double)(ay-by)/(ax-bx);
        double bToCSlope = (double)(by-cy)/(bx-cx);

        pw.println(aToBSlope == bToCSlope ? "No" : "Yes");
        pw.close();
    }
}