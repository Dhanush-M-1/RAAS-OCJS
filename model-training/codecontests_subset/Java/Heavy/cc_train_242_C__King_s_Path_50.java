// package Practice3.CF242;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class CF242C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] first = new int[2];
        int[] second = new int[2];
//        HashMap<Integer, TreeSet<pair>> map = new HashMap<>();
        TreeSet<pair> set = new TreeSet<>();
        for (int i = 0; i < 2; i++) {
            first[i] = s.nextInt();
        }

//        set.add(new pair(47,31));
        for (int i = 0; i < 2; i++) {
            second[i] = s.nextInt();
        }

        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            for (int j = b; j <= c; j++) {
                set.add(new pair(a,j));
            }
        }

        TreeSet<pair> visited = new TreeSet<>();
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(first[0],first[1]));
        queue.add(null);

        int[] dx = {0,0,1,1,1,-1,-1,-1};
        int[] dy = {-1,1,-1,0,1,-1,0,1};
        visited.add(new pair(first[0],first[1]));

        int count = 0;
        while (!queue.isEmpty()){
            pair p = queue.poll();
            if(p != null && p.equals(new pair(second[0],second[1]))){
//                return count;
                System.out.println(count);
                break;
            }
            if(p == null){
                p = queue.poll();
                count++;
                if(p == null){
                    System.out.println(-1);
                    break;
                }else if(p.equals(new pair(second[0],second[1]))){
                    System.out.println(count);
                    break;
                }
                queue.add(null);
            }
            for (int i = 0; i < 8; i++) {
                pair p1 = new pair(p.x + dx[i],p.y + dy[i]);
                if(!visited.contains(p1) && set.contains(p1)) {
                    queue.add(p1);
                    visited.add(p1);
                }
            }
        }
    }

    private static class pair implements Comparable<pair>{
        int x;
        int y;

        @Override
        public boolean equals(Object obj) {
            pair p = (pair)obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return this.x *31 + this.y *47;
        }

        public pair(int from, int to) {
            this.x = from;
            this.y = to;
        }

        @Override
        public int compareTo(pair o) {
            if(this.x == o.x){
                return Integer.compare(this.y,o.y);
            }
            return Integer.compare(this.x, o.x);
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}