

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        int[] a = new int[n];
        in=br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(in[i]);
        }
        int max = -1;
        int ans = -1;
        for(int i=0;i<n;i++) {
            if(k>=a[i] && k%a[i]==0 && a[i] > max) {
                max = a[i];
                ans = k/max;
            }
        }
        bw.append(ans+"\n");
        bw.close();
        
        
    }

    

    

}
