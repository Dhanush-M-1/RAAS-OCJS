// package ArraysAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class EqualizingByDivision {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line[]=br.readLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int k=Integer.parseInt(line[1]);
        ArrayList<Integer> count[]=new ArrayList[200001];
        for(int i=0;i<count.length;i++){
            count[i]=new ArrayList<>();
        }
        line=br.readLine().split(" ");
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(line[i]);
        }
        for(int i=0;i<n;i++){
            int curr=a[i];
            int t=0;
            count[curr].add(t);
            while(curr>0){
                curr/=2;
                t++;
                count[curr].add(t);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<count.length;i++){
            if(count[i].size()>=k){
                Collections.sort(count[i]);
                int sum=0;
                for(int j=0;j<k;j++){
                    sum+=count[i].get(j);
                }
                min=Math.min(min,sum);
            }
        }
        System.out.println(min);
    }
}
