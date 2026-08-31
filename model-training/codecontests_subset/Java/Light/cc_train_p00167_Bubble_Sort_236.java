import java.util.*;

public class Main{
    static int mergecount(ArrayList<Integer> a){
        int count = 0;
        int n = a.size();

        if(n > 1){
            ArrayList<Integer> b = new ArrayList<Integer>();
            for(int i = 0; i < n / 2; i++) b.add(a.get(i));
            ArrayList<Integer> c = new ArrayList<Integer>();
            for(int i = n / 2; i < n; i++) c.add(a.get(i));

            count += mergecount(b);
            count += mergecount(c);
            for(int i=0, j=0, k=0; i < n; i++){
                if(k == c.size())      a.set(i, b.get(j++));
                else if(j == b.size()) a.set(i, c.get(k++));
                else if(b.get(j) <= c.get(k))  a.set(i, b.get(j++));
                else                 { a.set(i, c.get(k++)); count += n / 2 - j; }
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            if(n == 0) break;
            ArrayList<Integer> al = new ArrayList<Integer>();

            for(int i = 0; i < n; i++){
                al.add(sc.nextInt());
            }

            System.out.println(mergecount(al));
        }
    }
}