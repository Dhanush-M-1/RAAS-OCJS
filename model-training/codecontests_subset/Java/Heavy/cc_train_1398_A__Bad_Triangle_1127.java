import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            int arr[] = new int[x];
            for (int i = 0; i < x; i++)
                arr[i] = sc.nextInt();
            int a = 0, b = 0, c = 0;
            boolean flag = false;
            for (int i = 0; i < x; i++) {
                for(int j=i+1;j<x-1;j++)
                {
                    if(arr[i]+arr[j]<=arr[x-1])
                        flag = true;
                        a = i+1;
                        b = j + 1;
                        c = x;
                        break;
                }
                if(flag)
                    break;
            }
            if (flag)
                System.out.println(a + " " + b + " " + c);
            else
                System.out.println(-1);
            System.out.println();
        }
    }

}