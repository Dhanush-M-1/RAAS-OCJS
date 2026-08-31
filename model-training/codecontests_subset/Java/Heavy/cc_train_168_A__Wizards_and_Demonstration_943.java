import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileReader; 
import java.io.FileWriter;
//import java.lang.StringBuilder;
import java.util.StringTokenizer;
//import java.lang.Comparable;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.LinkedList;

public class WizardsAndDemonstration {
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    //static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int m = 0;
        if((n * p) % 100 == 0) {
            m = n * p / 100;
        } else {
            double pc = (n / 100.0) * p;
            m = (int)(pc)+1;
        }
        out.print(Math.max(0, (m - w)));
        out.close();
    }
}