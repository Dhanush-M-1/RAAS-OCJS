import java.util.*;
import java.io.*;

public class Test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int arr[] = new int[3];
        for(int i = 0; i <= 2; i++) {
            int p = 0;
            for(int j = 0;j < n-i; j++) {
                int key = sc.nextInt();
                p ^= key; 
            }
            arr[i] = p;
        }
        System.out.println(arr[0]^arr[1]);
        System.out.println(arr[1]^arr[2]);
    }
}