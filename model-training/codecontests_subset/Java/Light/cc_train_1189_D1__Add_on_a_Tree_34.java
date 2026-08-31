import java.util.Scanner;

public class Code {

    public static int[] arr = new int[200005], sum = new int[100005];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<=n;i++)arr[i]=0;
        for(int i=1;i<n;i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            arr[a]++;
            arr[b]++;
        }
        for(int i=1;i<=n;i++) {
            if(arr[i]==2) {
                System.out.printf("NO");
                return;
            }
        }
        System.out.printf("YES");
    }
}
