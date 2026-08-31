import java.util.*;

public class Main {

    static class Pair{
        public int x;
        public StringBuilder y;
        public Pair(int x,StringBuilder y) {
            this.x=x;
            this.y=y;
        }
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Pair) {
                Pair other = (Pair) obj;
                return other.x==this.x && other.y==this.y;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(this.x,this.y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        StringBuilder fst = new StringBuilder();
        fst.append('a');
        Pair first = new Pair(1, fst);
        q.add(first);
        for (int i=0;i<N-1;i++) {
            int cnt = q.size();
            // System.out.println(cnt);
            while (!q.isEmpty()) {
                Pair rem = q.poll();
                // System.out.println(rem.y);
                for (int j=0;j<rem.x+1;j++) {
                    StringBuilder add = new StringBuilder(rem.y);
                    add.append((char)((int)'a'+j));
                    int num = rem.x;
                    if (j==rem.x) num++;
                    Pair add_pair = new Pair(num, add);
                    q.add(add_pair);
                }
                cnt--;
                if (cnt==0) break;
            }
        }
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            System.out.println(rem.y);
        }
    }
}