import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class C500 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int ans = 0;
        
        int n = scanner.nextInt();
        int numOfDays = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        int[] readOrder = new int[numOfDays];
        LinkedList<Integer> bookOrder = new LinkedList<Integer>();
        for (int i = 0; i < numOfDays; i++) {
            int bookNo = scanner.nextInt();
            readOrder[i] = bookNo;
            if (!bookOrder.contains(bookNo)) {
                bookOrder.add(bookNo);
            }
        }
        scanner.close();
        
        for (int i = 0; i < numOfDays; i++) {
            int bookNo = readOrder[i];
            int currentSum = 0;
            for (int j = 0; j < n; j++) {
                if (bookOrder.get(j)!= bookNo) {
                    currentSum += weights[bookOrder.get(j)-1];
                } else {
                    //Move this element at the top of the linkedList
                    Integer element = bookOrder.get(j);
                    bookOrder.remove(j);
                    bookOrder.addFirst(element);
                    break;
                }
            }
            ans += currentSum;
        }
        System.out.println(ans);
    }
}