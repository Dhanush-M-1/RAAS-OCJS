import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] buckets = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            buckets[i] = input.nextInt();
        }
        maxHeapMaker(buckets);
        heapSort(buckets);
        for (int i = buckets.length - 1; i >= 1 ; i--) {
//            System.out.println(buckets[i]);
            if (k % buckets[i] == 0){
                System.out.println(k / buckets[i]);
                return;
            }
        }
    }
    public static void minHeapMaker(int[] income){
        for (int i = ((income.length - 1) / 2); i >= 1; i--) {
            minHeapify(income, income.length - 1, i);
        }
    }
    public static void minHeapify(int[] income, int heapSize, int i){
        int smallest = i;
        if (2 * i < heapSize){
            if (income[2 * i] < income[smallest]){
                smallest = 2 * i;
            }
        }
        if ((2*i) + 1 < heapSize){
            if (income[(2*i) + 1] < income[smallest]){
                smallest = (2*i) + 1;
            }
        }
        if (smallest != i){
            int temp = income[i];
            income[i] = income[smallest];
            income[smallest] = temp;
            minHeapify(income, heapSize, smallest);
        }
    }

    public static void maxHeapMaker(int[] income){
        for (int i = (income.length - 1) / 2; i > 0; i--) {
            maxHeapify(income, income.length - 1, i);
        }
    }
    public static void maxHeapify(int[] income, int heapSize, int i){
        int largest = i;
        if (2 * i < heapSize + 1){
            if (income[2*i] > income[largest]){
                largest = 2 * i;
            }
            if ((2*i) + 1 < heapSize + 1){
                if (income[(2*i) + 1] > income[largest]){
                    largest = (2 * i) + 1;
                }
            }
            if (largest != i){
                int temp = income[largest];
                income[largest] = income[i];
                income[i] = temp;
                maxHeapify(income, heapSize, largest);
            }
        }
    }

    public static void heapSort(int[] income){
        int heapSize = income.length - 1;
        for (int i = income.length - 1; i > 1; i--) {
            int temp = income[1];
            income[1] = income[i];
            income[i] = temp;
            heapSize -= 1;
            maxHeapify(income, heapSize,1);
//            minHeapify();
        }
    }
}
