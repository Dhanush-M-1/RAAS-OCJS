import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            PriorityQueue<long[]> lq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
            PriorityQueue<long[]> rq = new PriorityQueue<>((x, y) -> Long.compare(y[0], x[0]));
            long ans = 0L;
            for (int i = 0; i < n; i++) {
                long k = sc.nextLong();
                long l = sc.nextLong();
                long r = sc.nextLong();
                if(l < r){
                    rq.add(new long[]{k, r-l});
                    ans += l;
                }else{
                    lq.add(new long[]{k, l-r});
                    ans += r;
                }
            }
            PriorityQueue<Long> tmplq = new PriorityQueue<>();
            while(!lq.isEmpty()){
                long[] a = lq.poll();
                if(tmplq.size() < a[0]){
                    ans += a[1];
                    tmplq.add(a[1]);
                }else{
                    long tmpa = tmplq.peek();
                    if(tmpa < a[1]){
                        tmplq.poll();
                        tmplq.add(a[1]);
                        ans += a[1] - tmpa;
                    }
                }
            }
            PriorityQueue<Long> tmprq = new PriorityQueue<>();
            while(!rq.isEmpty()){
                long[] a = rq.poll();
                if(tmprq.size() < n-a[0]){
                    ans += a[1];
                    tmprq.add(a[1]);
                }else{
                    Long tmpa = tmprq.peek();
                    if(tmpa != null && tmpa < a[1]){
                        tmprq.poll();
                        tmprq.add(a[1]);
                        ans += a[1] - tmpa;
                    }
                }
            }
            sb.append(ans +"\n");
        }
        System.out.println(sb.toString());
        sc.close();

    }

}
