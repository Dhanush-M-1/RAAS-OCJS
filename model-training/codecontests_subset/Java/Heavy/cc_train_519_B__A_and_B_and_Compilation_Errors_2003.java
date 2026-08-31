import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import java.util.List;

public class cod {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        BufferedWriter bw = new BufferedWriter(pw);
        String s1=br.readLine();
        int n=Integer.parseInt(s1);
        String s2[]=br.readLine().split(" ");
        int[] a=new int[n];
        int[] b=new int[n-1];
        int[] c=new int[n-2];
        int fir=0;int sec=0;
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s2[i]);
        }
        String s3[]=br.readLine().split(" ");
        String s4[]=br.readLine().split(" ");
        for(int i=0;i<n-1;i++){
            b[i]=Integer.parseInt(s3[i]);
        }
        for(int i=0;i<n-2;i++){
            c[i]=Integer.parseInt(s4[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int count=0;
        for(int i=0;i<n-1;i++){
            if(a[i]!=b[i]){
                fir=a[i];
                count++;
                break;
            }
        }
        if(count==0)
            fir=a[n-1];
        count=0;
        for(int i=0;i<n-2;i++){
            if(b[i]!=c[i]){
                sec=b[i];
                count++;
                break;
            }
        }
        if(count==0)
            sec=b[n-2];
        bw.write(fir+"\n");
        bw.write(sec+"\n");
        bw.flush();
    }

}
