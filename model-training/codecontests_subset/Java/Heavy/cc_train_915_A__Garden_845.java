import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by sky on 13/1/18.
 * www.github.com/aakashjaiswal1
 * aakashjaiswal@hotmail.co.in
 * aakashjaiswal.in@gmail.com
 * people die if they are killed
 */
public class fee {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
      //  int T=scrn.nextInt();
      //  while (T-->0){
            int no=scrn.nextInt();
            int capacity=scrn.nextInt();
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            for (int i=0;i<no;++i){
                pq.add(scrn.nextInt());
            }

            while (true){
                int item=pq.poll();
            if (capacity%item==0){
                int ans=capacity/item;
                System.out.println(ans);
                break;
            }
            }
        }
    //}
}
