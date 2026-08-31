import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < w.length; i++) {
            w[i] = sc.nextInt();
        }
        LinkedList<Integer> bookList = new LinkedList<Integer>();
        int[] b = new int[m];
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
            if (!bookList.contains(b[i])){
                bookList.add(b[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            int id = bookList.indexOf(b[i]);
            Iterator<Integer> it = bookList.iterator();
            Integer next = it.next();
            while (next != b[i]){
                sum += w[next-1];
                next = it.next();
            }
            bookList.remove(id);
            bookList.addFirst(b[i]);
        }
        System.out.println(sum);
    }

}