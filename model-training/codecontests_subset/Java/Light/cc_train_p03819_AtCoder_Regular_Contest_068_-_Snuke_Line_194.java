import java.io.*;
import java.util.*;
public class Main{
    static int find(int bit[],int pos){
        int ans = 0;
        while(pos > 0){
            ans += bit[pos];
            pos -= (pos & -pos);
        }
        return ans;
    }
    static void update(int pos,int val,int bit[]){
        while(pos < bit.length){
            bit[pos] += val;
            pos += (pos & -pos);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node>list[] = new ArrayList[m + 1];
        for(int i = 1;i <= m;i++)
            list[i] = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[end - start + 1].add(new Node(start,end));
        }
        int bit[] = new int[m + 1];
        int fix = n;
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= m;i++){
            int ans = 0;
            for(int j = i;j <= m;j += i){
                ans += find(bit,j);
                //System.out.println(ans + " " + i + " " + j);
            }
            for(Node temp : list[i]){
                update(temp.start,1,bit);
                update(temp.end + 1,-1,bit);
                //System.out.println(temp.start)
            }
            sb.append(ans + fix);
            sb.append('\n');
            fix -= list[i].size();
        }
        System.out.println(sb);
    }
    static class Node {
        int start;
        int end;
        Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
}
