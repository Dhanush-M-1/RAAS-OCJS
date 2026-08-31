import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;


 public class Main{

    
    
     
     public static void main(String[] args) throws IOException {
        String IN = "C:\\Users\\ugochukwu.okeke\\Desktop\\in.file";
        String OUT = "C:\\Users\\ugochukwu.okeke\\Desktop\\out.file";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] in= br.readLine().split(" ");
        int n=Integer.parseInt(in[0]),k=Integer.parseInt(in[1]),s=Integer.parseInt(in[2]),t=Integer.parseInt(in[3]);
        int[][] store = new int[n][2];
        for(int i=0;i<n;i++) {
            in=br.readLine().split(" ");
            store[i][0] = Integer.parseInt(in[0]);
            store[i][1] = Integer.parseInt(in[1]);
        }
        int[] a = new int[k+2];
        in=br.readLine().split(" ");
        
        for(int i=0;i<in.length;i++) {
            a[i+1]=Integer.parseInt(in[i]);
            
        }
        
        a[a.length-1] = s;
        
        Arrays.sort(a);
        
        int w = findBest(a, t);
        
        //System.out.println("best time is "+w);
//        System.exit(0);
        int ans = 1000000001;
        for(int i=0;i<n;i++) {
            if(store[i][1] >= w) {
                ans = Math.min(store[i][0], ans);
            }
        }
        if(ans == 1000000001) bw.append("-1\n");
        else bw.append(ans+"\n");
        bw.close();
        //done then
         
     }

    private static int findBest(int[] a, int t) {
        int lo=0;
        int hi=1000000001;
        while(lo < hi) {
            
            int mid = lo+hi>>1; //: capacity in fuel
            //mid=9;
            //System.out.println("using fuel cap of  "+mid);
            boolean bad = false;
            int totalTime = 0;
            for(int i=1;i<a.length;i++) {
                int d = a[i]-a[i-1];
                if(d  > mid){
                    bad = true;
                    break;
                }
                else{
                    int k1 = Math.min(d, mid-d);
                    int k2 = d-k1;
                    //System.out.println(k1+" "+k2);
                    totalTime += k1+2*k2;
                }
                
                if(totalTime > t) {
                    
                    bad=true;
                    break;
                }
            }
            if(bad) lo=mid+1;
            else hi=mid;
            
        }
        return lo;
    }
 }