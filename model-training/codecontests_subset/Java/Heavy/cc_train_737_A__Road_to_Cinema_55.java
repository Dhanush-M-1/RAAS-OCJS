import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main
{
    static class Car{
        int price, fuelTankCapacity;
        public Car(int price, int fuelTankCapacity){
            this.price = price;
            this.fuelTankCapacity = fuelTankCapacity;
        }
    }

    static long minTimeToCover(int distance, int fuelTankCapacity){
        int l = 0, r = distance, mid = 0, x = 0, y = 0;

        while(l <= r){
            mid = l + (r - l) / 2;
            if(mid * 2l + (distance - mid) * 1l <= fuelTankCapacity){
                x = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        // cover distance x in accelerated mode and (distance - x) (let y) in normal mode
        y = distance - x;
        long time = y * 2l + x * 1l;
        return time; 
    }

    static boolean canUseCar(Car C, int stops[], int n, int k, int t){
        int price = C.price, fuelTankCapacity = C.fuelTankCapacity;
        long totalTime = 0l;

        for(int i = 0; i <= k; i++){
            int distance = stops[i + 1] - stops[i];
            if(distance > fuelTankCapacity)
                return false;
            
            totalTime += minTimeToCover(distance, fuelTankCapacity);
        }

        return totalTime <= t;
    }

    public static void process(int test_number)throws IOException
    {
        int n = ni(), k = ni(), s = ni(), t = ni(), stops[] = new int[k + 2], suff[] = new int[n];
        Car arr[] = new Car[n];

        for(int i = 0; i < n; i++){
            int price = ni(), fuelTankCapacity = ni();
            arr[i] = new Car(price, fuelTankCapacity);
        }        

        Arrays.sort(arr, (A, B) -> (A.fuelTankCapacity != B.fuelTankCapacity ? 
                                        A.fuelTankCapacity - B.fuelTankCapacity : A.price - B.price)); // sort by fuelTankCapacity

        for(int i = 0; i < n; i++){
            trace(arr[i].fuelTankCapacity, arr[i].price);
        }

        suff[n - 1] = arr[n - 1].price;
        for(int i = n - 2; i >= 0; i--)
            suff[i] = Math.min(suff[i + 1], arr[i].price);

        stops[k + 1] = s;
        for(int i = 1; i <= k; i++)
            stops[i] = ni();
        sort(stops);

        int l = 0, r = n - 1, mid = 0, res = -1;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(canUseCar(arr[mid], stops, n, k, t)){
                res = suff[mid];
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        pn(res);
    }
    
    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static final long mod = (long)1e9+7l;
    static boolean DEBUG = false;
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc = new FastReader();
 
        long s = System.currentTimeMillis();
        int t = 1;
        for(int i = 1; i <= t; i++)
            process(i);
 
        out.flush();
        System.err.println(System.currentTimeMillis()-s+"ms");
    }

    static void trace(Object... o){ if(!DEBUG) return; System.err.println(Arrays.deepToString(o)); };    
    static void pn(Object o){ out.println(o); }
    static void p(Object o){ out.print(o); }
    static int ni()throws IOException{ return Integer.parseInt(sc.next()); }
    static long nl()throws IOException{ return Long.parseLong(sc.next()); }
    static double nd()throws IOException{ return Double.parseDouble(sc.next()); }
    static String nln()throws IOException{ return sc.nextLine(); }
    static long gcd(long a, long b){ return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b){ return (b==0)?a:gcd(b,a%b); }
    
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
    } 
}
