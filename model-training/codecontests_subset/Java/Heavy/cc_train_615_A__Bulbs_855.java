import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {

   

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        
        String[] in = br.readLine().split(" ");
        
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        
        HashMap<Integer, Integer> H = new HashMap();
        int val = 0;
        for(int i=0;i<n;i++){
            //System.out.println("here");
            in=br.readLine().split(" ");
            
            int cnt = Integer.parseInt(in[0]);
            
            for(int j=0;j<cnt;j++){
                int t = Integer.parseInt(in[j+1]);
                if(!H.containsKey(t)){
                    val+=1;
                    H.put(t,1);
                }
            }
        }
        
        if(val < m) System.out.println("NO");
        else    System.out.println("YES");
        
    }

}
//L65644020
    //20151UYO31284713