import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Iterator;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.BitSet;
import java.lang.StringBuilder;
import java.util.Queue;
import java.util.Objects;
import java.util.PriorityQueue;
public class UvaProblems {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        Locale.setDefault(new Locale("en", "US"));
        
        int n = Integer.parseInt(in.readLine());
        String a = in.readLine();
        int total8s = 0;
        for(int i = 0; i<a.length(); i++) {
        	if(a.charAt(i) == '8') {
        		total8s ++;
        	}
        }
        int veces = n/11;
        if(total8s >= veces) {
        	out.println(veces);
        }
        else if(total8s == 0) {
        	out.println(0);
        }
        else if(total8s < veces){
        	out.println(total8s);
        }
        
        out.flush();
    }
}
