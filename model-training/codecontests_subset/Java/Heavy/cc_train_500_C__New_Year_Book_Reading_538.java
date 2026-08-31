import java.io.BufferedInputStream;
import java.util.*;

/**
 * Created by admin on 2016/7/22.
 */
public class main1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int bookNum = scanner.nextInt();
        int dayNum = scanner.nextInt();
        int[] books = new int[bookNum];
        int[] orders = new int[dayNum];


        for(int i = 0 ; i < bookNum ; i ++){
            books[i] = scanner.nextInt();
        }

        for(int i = 0 ; i < dayNum; i++){
            orders[i] = scanner.nextInt();
        }

        Set<Integer> tmpSet = new HashSet<>();
        ArrayList<Integer> tmpArray = new ArrayList<>();
        for(int i = 0; i < dayNum; i++){
            if(tmpSet.add(orders[i])){
                tmpArray.add(orders[i]);
            }
        }

        int totalSize = 0;
        for(int i = 0 ; i < orders.length; i++){
            totalSize = totalSize + cal(books, tmpArray, orders[i]);
        }
        System.out.println(totalSize);
    }

    public static int cal(int[] book, ArrayList<Integer> order, int bookOrder){
        int realbookOrder = 0;
        int totalSize = 0;
        for(int i = 0 ; i < order.size(); i++){
            if(order.get(i) == bookOrder){
                realbookOrder = i;
                break;
            }

            totalSize = totalSize + book[order.get(i) - 1];
        }
        order.remove(realbookOrder);
        order.add(0, bookOrder);
        return totalSize;
    }
}

  		    		 		 	 	   	    	 			