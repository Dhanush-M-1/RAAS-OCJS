import java.util.*;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n - 1];
        int[] arr3 = new int[n - 2];
        for (int i = 0; i < n ; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1 ; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 2 ; i++) {
            arr3[i] = sc.nextInt();
        }
        int summand1 = 0, summand2 = 0, res = 0;
        for (int i = 0; i < n ; i++) {
            summand1+= arr1[i];
        }
        for (int i = 0; i < n - 1 ; i++) {
            summand2 += arr2[i];
        }
        System.out.println(summand1-summand2);
        summand1 = 0;
        for (int i = 0; i < n - 2 ; i++) {
            summand1 += arr3[i];
        }
        System.out.println(summand2-summand1);
    }
}
