import java.util.*;

public class Main {
    
    private static void print(int[] arr) {
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    
    private static void print(long[] arr) {
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    
    private static void read(Scanner scan, int[]... arrs) {
        int len = arrs[0].length;
        for (int i = 0; i < len; i++) {
            for (int[] arr : arrs) {
                arr[i] = scan.nextInt();
            }
        }
    }
    
    private static void decreaseByOne(int[]... arrs) {
        for (int[] arr : arrs) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] --;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        int M = scan.nextInt();
        
        int[] add = new int[N];
        int[] max = new int[N];
        
        int[] type = new int[M];
        int[] left = new int[M];
        int[] right = new int[M];
        int[] value = new int[M];
        
        read(scan, type, left, right, value);
        decreaseByOne(left);
        
        int limit = (int)1e9;
        Arrays.fill(max, limit);
        for (int i = 0; i < M; i++) {
            if (type[i] == 1) {
                for (int j = left[i]; j < right[i]; j++) {
                    add[j] += value[i];
                }
            } else {
                for (int j = left[i]; j < right[i]; j++) {
                    max[j] = Math.min(max[j], value[i] - add[j]);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (Math.abs(max[i]) > limit) {
                System.out.println("NO");
                return;
            }
        }
        
        int[] mock = Arrays.copyOf(max, max.length);
        for (int i = 0; i < M; i++) {
            if (type[i] == 1) {
                for (int j = left[i]; j < right[i]; j++) {
                    mock[j] += value[i];
                }
            } else {
                int temp = Integer.MIN_VALUE;
                for (int j = left[i]; j < right[i]; j++) {
                    temp = Math.max(temp, mock[j]);
                }
                if (temp != value[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        System.out.println("YES");
        print(max);
        scan.close();
    }
}
