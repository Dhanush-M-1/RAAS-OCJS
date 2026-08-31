import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


public class Problem2 {

    /**
     * @param args
     */
    static class book implements Comparable<book> {

        int times, weight, number, count;

        public book(int aa, int bb, int cc, int dd) {
            times = aa;
            weight = bb;
            number = cc;
            count = dd;
        }

        @Override
        public int compareTo(book other) {
            if (count> other.count)
                return 1;
            else if (count< other.count)
                return -1;
            else{
                if (times> other.times)
                    return -1;
                else if(times< other.times)
                    return 1;
                return 0;
            }
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n+1];
        int[] b = new int[m];
        int [] numbers = new int[n+1];
        for (int i = 1; i < w.length; i++) {
            w[i] = sc.nextInt();
        }
        int counter = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
            if(!map.containsKey(b[i])){
                map.put(b[i], counter);
                counter ++;
            }
            numbers[b[i]]++;
        }
        PriorityQueue<book> pq = new PriorityQueue<>();
        for (int i = 1; i < numbers.length; i++) {
            if(map.containsKey(i))
                pq.add(new book(numbers[i], w[i], i, map.get(i)));
            else
                pq.add(new book(numbers[i], w[i], i, 1000000000));
        }
        int ww = 0;
        Stack<book> s = new Stack<>();
        while(pq.size()>0){
            book x = pq.poll();
            s.push(x);
        }
        Stack<book> need = new Stack<>();
        while(s.size() > 0){
            book x = s.pop();
            need.push(x);
        }
        Stack<book> another = new Stack<>();
        for (int i = 0; i < m; i++) {
            int bo = b[i];
            while(true){
                book x = need.pop();
                if(x.number == bo){
                    while(another.size() > 0){
                        need.push(another.pop());
                    }
                    need.push(x);
                    break;
                }
                another.push(x);
                ww += x.weight;
            }
        }
        System.out.println(ww);
    }

}
