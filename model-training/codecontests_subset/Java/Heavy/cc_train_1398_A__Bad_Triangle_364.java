
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeChef {
    static int mod = (int)1e9+7;
    public static void main(String[] args)  {
        Scanner sc = new Scanner();
        Functions f = new Functions();
        int testCase = sc.nextInt();
        while(testCase-->0){
            int n = sc.nextInt();
            int[] arr = sc.setIntegerArray(n);
            int sum = arr[0]+arr[1];
            int r = -1;
            for(int i=n-1;i>=0;i--){
                if(sum<=arr[i]){
                    r=i+1;
                    break;
                }
            }
            if(r==-1)
                System.out.println(r);
            else System.out.println("1 2 "+r);
        }
        
    }

}
class Scanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");
    public String next(){
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            }catch (IOException e){
                e.printStackTrace();
            }
        return st.nextToken();

    }
    public int nextInt(){
        return Integer.parseInt(next());
    }
    public long nextLong(){
        return Long.parseLong(next());
    }
    public int[] setIntegerArray(int n){
        int[] arr =new int[n];
        for(int i=0;i<n;i++)arr[i] = nextInt();
        return arr;
    }
    public long[] setLongArray(int n){
        long[] arr =new long[n];
        for(int i=0;i<n;i++)arr[i] = nextLong();
        return arr;
    }
}
class Functions extends CodeChef{
    public void sort(int[] a){
        ArrayList<Integer> temp = new ArrayList<>();
        for (int j : a) temp.add(j);
        Collections.sort(temp);;
        for(int i=0;i<a.length;i++)a[i] = temp.get(i);
    }
    public long factorial(int n){
        long fact = 1L;
        for(int i=2;i<=n;i++)fact=  (fact*i)%mod;
        return fact;
    }
    public void sortRev(int[] a){
         sort(a);
         int left = 0;
         int right = a.length-1;
         while (left<right){
             int temp =a[left];
             a[left] = a[right];
             a[right] = temp;
             left++;
             right--;
         }
    }
}