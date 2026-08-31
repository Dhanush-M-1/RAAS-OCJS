import java.util.Scanner;


public class Solution {

    public static void swap(int[] mas, int a, int b) {

        int tmp = mas[a];
        mas[a] = mas[b];
        mas[b] = tmp;


    }

    public static boolean alloc(int n, int[] array, int arraySize, int count) {
        boolean key = false;
        int dimension;
        int st = 0;
        int end = 0;

        for (int i = 0; i < arraySize; i++) {
            dimension = 0;
            st = i;
            end = i;
            for (int j = i; j < arraySize && array[j] == 0 && dimension < n; j++) {
                end++;
                dimension++;
            }

            if (dimension == n) {

                i = arraySize;
                key = true;
                for (int j = st; j < end; j++) {
                    array[j] = count;
                }
            }
        }

        if (!key) {
            return key;
        } else {
            return key;
        }


    }


    public static void erase(int[] array, int arraySize, int count) {

        boolean key = false;

        for (int i = 0; i < arraySize; i++) {
            if (array[i] == count) {
                array[i] = 0;
                key = true;
            }
        }

        if (!key || count == 0) {

            System.out.println("ILLEGAL_ERASE_ARGUMENT");
        }


    }

    public static void defragment(int[] array, int arraySize) {

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (array[j] == 0) {
                    while (j != arraySize - 1) {

                        swap(array, j, j + 1);
                        j++;
                    }
                    j = arraySize;
                }
            }

        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {

            a[i] = 0;
        }


        int count = 1;

        for (int i = 0; i < t; i++) {

            String s;
            s = scanner.next();
            int temp;


            if (s.compareTo("alloc") == 0) {
                temp = scanner.nextInt();
                if (!alloc(temp, a, m, count)) {
                    System.out.println("NULL");
                } else {
                    System.out.println(count);
                    count++;
                }

            } else if (s.compareTo("erase") == 0) {
                temp = scanner.nextInt();
                erase(a, m, temp);
            } else if (s.compareTo("defragment") == 0) {
                defragment(a, m);

            }

        }


    }
}