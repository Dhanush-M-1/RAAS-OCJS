import java.io.*;
import java.util.*;

public class Mafia {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberSpace = br.readLine();
        String integers = br.readLine();
        int numInts = Integer.parseInt(numberSpace);
        int arrNum[] = new int[numInts];
        int MAX =0;
        long SumDiff =0;
        int arrDiff[]=new int[numInts];
        StringTokenizer st = new StringTokenizer(integers);
        for (int i = 0; i < numInts; i++)
        {
            arrNum[i] = Integer.parseInt(st.nextToken());
            if(arrNum[i]>MAX) MAX=arrNum[i];
        }
        for (int i = 0; i < numInts; i++)
        {
            arrDiff[i]=MAX-arrNum[i];
            SumDiff+=arrDiff[i];
        }
        if(SumDiff>MAX) System.out.print(MAX);
        else
            System.out.print(MAX+(MAX-SumDiff+numInts-2)/(numInts-1));
    }
}