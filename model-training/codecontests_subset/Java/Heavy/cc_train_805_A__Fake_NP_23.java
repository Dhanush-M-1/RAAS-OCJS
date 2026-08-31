import java.util.ArrayList;
import java.util.Scanner;

public class FakeNP {
//    static ArrayList getDivisors(int n)
//    {
//        ArrayList<Integer> arr = new ArrayList<>();
//        for (int i=2;i<=n;i++)
//            if (n%i==0)
//                arr.add(i);
//        return arr;
//    }
//    static int getIndexOfLargest( int[] array )
//    {
//        if ( array == null || array.length == 0 ) return -1;
//
//        int largest = 0;
//        for ( int i = 1; i < array.length; i++ )
//        {
//            if ( array[i] >= array[largest] ) largest = i;
//        }
//        return largest;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        if (l == r){
            System.out.println(l);
        } else {
            System.out.println(2);
        }
//        int [] count = new int[r+1];
//        for (int i = l; i <= r ; i++) {
//            ArrayList<Integer> arr = getDivisors(i);
//            for (int j = 0; j < arr.size(); j++) {
//                count[arr.get(j)]++;
//            }
//        }
//        System.out.println(getIndexOfLargest(count));
    }
}
