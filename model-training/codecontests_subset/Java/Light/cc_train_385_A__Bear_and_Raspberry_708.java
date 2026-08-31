//package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    static int a[][];
    static int ct=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(st.nextToken());
        int max=0,diff;

        for(int i=0;i<n-1;i++){
            if(a[i+1]<a[i]){
                diff=a[i]-a[i+1];
                if(diff>max)
                    max=diff;
            }
        }
        System.out.println((max-c>0)?max-c:0);
    }
}
