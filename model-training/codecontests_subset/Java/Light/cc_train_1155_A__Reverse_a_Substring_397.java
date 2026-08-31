import java.io.*;
import java.util.*;
import static java.lang.Math.*;
public class Rough
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char arr[]= sc.next().toCharArray();
        for(int i =1;i<n;i++) {
            if(arr[i-1]>arr[i]) {
                System.out.println("YES");
                System.out.println((i)+" "+(i+1));
                System.exit(0);
            }
        }
        System.out.println("NO");
    }
}