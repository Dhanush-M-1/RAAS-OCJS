import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt(),k=s.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        Arrays.sort(a);
        int sel=0;
        for(int i=n-1;i>=0;i--){
            if(k%a[i]==0){
                sel=i;
                break;
            }
        }
        System.out.println(k/a[sel]);
    }
}
