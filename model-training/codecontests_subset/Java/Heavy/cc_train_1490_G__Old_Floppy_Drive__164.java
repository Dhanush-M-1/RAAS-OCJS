/*
TASK: template
LANG: JAVA
*/
import java.io.*;
import java.lang.*;
import java.util.*;

public class G1490 {
    public static void main(String[] args) throws IOException{
        StringBuffer ans = new StringBuffer();
        StringTokenizer st;
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(f.readLine());
        int t = Integer.parseInt(st.nextToken());
        int l = 0;
        for(;t > 0;t--){
            st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            point[] psums = new point[n+1];
            long max = 0;
            st = new StringTokenizer(f.readLine());
            psums[0] = new point(0);
            long currsum = 0;
            int when = 0;
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                currsum+=arr[i];
                psums[i+1] = new point(Math.max(psums[i].x, currsum));
                psums[i+1].y = i;
                max = Math.max(psums[i+1].x, max);
            }
            long add = 0;
            for(int i = 0; i < n; i++){
                add+=arr[i];
                if(add == max) {
                    when = i;
                    break;
                }
            }
            long change = currsum;
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < m; i++){
                l++;
                int curr = Integer.parseInt(st.nextToken());
//                if(l == 595){
//                    System.out.println(Arrays.toString(arr));
//                    System.out.println(curr);
//                }
                if(curr <= max){
                    int r = Arrays.binarySearch(psums, new point(curr));
                    if(r < 0)
                        r = -r-1;
                    ans.append(psums[r].y);
                }else{
                    if(change <= 0){
                        ans.append(-1);
                    }else{
                        //System.out.println(Arrays.toString(psums));
//                        int diff = 0;
//                        while (curr > max){
//                            curr-=change;
//                            diff++;
//                        }
                        long diff = (curr - max + change - 1) / change;
                        long op = (diff) *n;
                        //System.out.println(curr-op);
                        //System.out.println(op);
                        int r = Arrays.binarySearch(psums, new point(curr - (diff*change)));
                        if(r < 0)
                            r = -r-1;
                        //System.out.println(r);
                        //System.out.println(psums[r].y + " " + op);
                        ans.append(op+r-1);
                    }
                }
                ans.append(" ");
            }
            ans.append("\n");


        }
        f.close();


        System.out.println(ans);

    }
    public static class point implements Comparable<point>{
        long x;
        long y;
        public point(long x){
            this.x = x;
        }
        public String toString(){
            return(x + " " + y);
        }
        public boolean equals(Object x){
            point y = ((point)(x));
            if (this.x == y.x && this.y == y.y){
                return true;
            }
            return false;
        }
        public int hashCode(){
            return Objects.hash(x,y);
        }
        public int compareTo(point other){
            if(this.x > other.x || (this.x == other.x && this.y > other.y)){
                return 1;
            }else if(this.x == other.x && this.y == other.y){
                return 0;
            }
            return -1;
        }
    }
}