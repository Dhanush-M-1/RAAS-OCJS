import java.util.*;

public class Main {
    static int n;
    static int max;
    static int a;
    static int b;
    static int c;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        max=a*c;
        n=(int) Math.ceil(max/b);
        System.out.println(binarySearch());
    }
    
    public static int binarySearch() {
         int low = 0;
         int high = n;
         int key=max;
         int b=-1;
         while (low <= high) {
             int mid = (low + high)>>>1;
             int midVal = getHours(mid);

             if (midVal < key)
             {
                 low = mid + 1;
             }
             else
             {
                high = mid - 1;
                b=mid;
             }
         }
         return b;
     }
    
    public static int getHours(int i) {
            int sum1 =0;
            int sum2 =i*b;
            while(true)
            {
                sum1+=a;
                sum2+=b;
                if(sum1>sum2 || sum2>=max) return sum2;
            }
     }
}
