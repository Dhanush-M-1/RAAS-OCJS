import java.util.*;
import java.io.*;
import java.math.*;

public class B {
    public static Scanner scan = new Scanner(System.in);
    public static boolean bg = false;
    public static int n = 0;
    public static int x = 0;
    public static ArrayList<Integer> sizes = new ArrayList();
    public static int self = -1;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(scan.next());
        x = Integer.parseInt(scan.next());
        int[] l1 = new int[n];
        ArrayList<Integer>[] al = new ArrayList[n];
        for (int i=0;i<n;i++){
            al[i]=new ArrayList();
        }
        for (int i=0;i<n;i++){
            int cur =Integer.parseInt(scan.next());
            l1[i]=cur;
            if (cur==0){
                continue;
            }
            cur -= 1;
            al[i].add(cur);
            al[cur].add(i);
            
        }
        int ptr = 0;
        boolean[] cov = new boolean[n];
        sizes = new ArrayList();
        self = -1;
        for (;;){
            ArrayList<Integer> tm1 = new ArrayList();
            LinkedList<Integer> q1 = new LinkedList();
            q1.add(ptr);
            cov[ptr]=true;
            boolean in = false;
            for (;;){
                if (q1.size()==0) break;
                int temp = q1.pollFirst();
                if (temp==x-1) in=true;
                tm1.add(temp);
                
                for (int e: al[temp]){
                    if (cov[e]!=true){
                        q1.add(e);
                        cov[e]=true;
                    }
                }
            }
            if (bg) System.out.println(tm1);
            if (in){
                self = tm1.size();
            }
            else {
                sizes.add(tm1.size());
            }
            boolean ex = false;
            for (;;){
                if (ptr>=cov.length){
                    ex=true;
                    break;
                }
                if (cov[ptr]==true){
                    ptr++;
                }
                else {
                    break;
                }
            }
            if (ex) break;
        }
        self = 1;
        int sptr = x;
        for (;;){
            if (l1[sptr-1]==0){
                break;
            }
            else {
                self++;
                sptr = l1[sptr-1];
            }
        }
        Collections.sort(sizes);
        HashSet<Integer> s1 = new HashSet();
        s1.add(0);
        HashSet<Integer> s2 = new HashSet();
        for (int i=sizes.size()-1;i>=0;i--){
            int cur = sizes.get(i);
            for (int e: s1){
                s2.add(e);
                if (e+cur<=n) s2.add(e+cur);
            }
            s1 = s2;
            s2 = new HashSet();
            if (bg) System.out.println(s1);
        }
        
        if (bg) System.out.println();
        if (bg) System.out.println(sizes);
        if (bg) System.out.println(self);
        ArrayList<Integer> fin1 = new ArrayList();
        fin1.addAll(s1);
        Collections.sort(fin1);
        for (int e: fin1){
            if (e+self>=1
                    &&e+self<=n
                    ){
                System.out.println(e+self);
            }
        }
        /**
        for (int i=0;i<poss.length;i++){
            if (poss[i]){
                if (i+self>=1
                        &&i+self<=n
                        ){
                    System.out.println(i+self);
                }
                
            }
        }
        **/
    }
    
}
