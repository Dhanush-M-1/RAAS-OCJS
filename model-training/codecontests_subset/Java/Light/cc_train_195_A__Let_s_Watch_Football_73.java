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

public class LetsWatchFootball {
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    //static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());
        //BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = c * (a - b);
        if(n % b == 0) {
            out.print(n / b);
        } else {
            out.print(((int)(n / b) + 1));
        }
        out.close();
    }
}