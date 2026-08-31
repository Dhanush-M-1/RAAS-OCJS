// package Div2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ProblemE {
    public static void isPossible(ArrayList<Integer> road[],int curr,int end,boolean visited[]){
        visited[curr]=true;
        if(curr==end){
            return;
        }
        ArrayList<Integer> friends=road[curr];
        for(int i=0;i<friends.size();i++){
            int temp=friends.get(i);
            if(!visited[temp]){
                isPossible(road,temp,end,visited);
            }
        }
    }
    public static void fill(ArrayList<Integer> road[],int curr,int end,boolean visited[]){
        visited[curr]=true;
        ArrayList<Integer> friends=road[curr];
        for(int i=0;i<friends.size();i++){
            int temp=friends.get(i);
            boolean seen[]=new boolean[visited.length];
            seen[curr]=true;
            isPossible(road,temp,end,seen);
            if(seen[end]){
//                System.out.println(temp+"x");
                for(int j=1;j<visited.length;j++){
                    if(seen[j]){
                        visited[j]=true;
                    }
                }
            }
        }
    }
    public static void dfs(ArrayList<Integer> road[],Integer start,boolean visited[]){
        visited[start]=true;
        ArrayList<Integer> friends=road[start];
        for(int i=0;i<friends.size();i++){
            int temp=friends.get(i);
            if(!visited[temp]){
                dfs(road,temp,visited);
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine());
        StringBuilder print=new StringBuilder();
        while(q--!=0){
            String line[]=br.readLine().split(" ");
            int n=Integer.parseInt(line[0]);
            int m=Integer.parseInt(line[1]);
            int a=Integer.parseInt(line[2]);
            int b=Integer.parseInt(line[3]);
            ArrayList<Integer> road[]=new ArrayList[n+1];
            for(int i=1;i<=n;i++){
                road[i]=new ArrayList<>();
            }
            for(int i=1;i<=m;i++){
                line=br.readLine().split(" ");
                int x=Integer.parseInt(line[0]);
                int y=Integer.parseInt(line[1]);
                road[x].add(y);
                road[y].add(x);
            }
            boolean visited[]=new boolean[n+1];
            fill(road,a,b,visited);
            int total=0;
            int start=0;
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    total++;
                    start=i;
                }
            }
            int left=0,right=0;
            if(start==0){
                print.append("0\n");
                continue;
            }
            dfs(road,b,visited);
//            System.out.println(start);
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    left++;
//                    System.out.println(i+"x");
                }
            }
            right=total-left;
            long ans=(long)left*right;
            print.append(ans+"\n");
//            System.out.println(total+" "+left+" "+right);
        }
        System.out.println(print.toString());
    }
}
