import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.Comparator;

public class scratch_25 {
    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * call this method to initialize reader for InputStream
         */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }


    static class ans {
        int a;
        int b;

        public ans(int a, int b) {
            this.a = a;
            this.b = b;

        }
    }

    static class sort implements Comparator<ans> {


        @Override
        public int compare(ans a1, ans a2) {
            return a1.b - a2.b;
        }


    }


    public static void main(String[] args) throws IOException  {
        Reader.init(System.in);
        long x0 = Reader.nextInt();
        long y0 = Reader.nextInt();
        long x1= Reader.nextInt();
        long y1= Reader.nextInt();
        int n= Reader.nextInt();
        HashMap<Long,ArrayList<long[]>> map = new HashMap<>();  // has allowed positions

        for (int i = 0; i <n ; i++) {
         long r= Reader.nextInt();
         long st= Reader.nextInt();
         long ed= Reader.nextInt();
         if(!map.containsKey(r)){
             ArrayList<long[]> arr= new ArrayList<>();
             long[] arr1 = {st,ed};
             arr.add(arr1);
             map.put(r,arr);
         }
         else{
             long arr1[]= {st,ed};
             map.get(r).add(arr1);
         }
        }


        long u= bfs(x0,y0,x1,y1,0,map);
        System.out.println(u);


























        }






public static long bfs(long x1, long y1, long x2, long y2, long num , HashMap<Long,ArrayList<long[]>> map) {
    HashMap<Long, ArrayList<Long>> vis= new HashMap<>();

    ArrayList<Long> ar= new ArrayList<>();
    ar.add(y1);
    vis.put(x1,ar);




    LinkedList<long[]> q = new LinkedList<>();
    long arr1[] = {x1,y1,num};
    q.addLast(arr1);


    int[][] arr = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1,0}};
    //   int min= Integer.MAX_VALUE;

    while (!q.isEmpty()){
       // System.out.println("bs");

        long arr2[]= q.removeFirst();
        long x= arr2[0];
        long y= arr2[1];
        long dis= arr2[2];

        if (x == x2 && y == y2) {
            //vis[x1][y1] = 1;
            return dis;
        }


        for (int i = 0; i <arr.length ; i++) {
           // System.out.println("bc");
            long xn= x+arr[i][0];
            long yn= y+arr[i][1];
            long dn= dis+1;













            if(map.containsKey(xn)) {
                ArrayList<long[]> ar1 = map.get(xn);
                boolean b = false;
                for (int j = 0; j < ar1.size(); j++) {
                    long l1 = ar1.get(j)[0];
                    long l2 = ar1.get(j)[1];
                   // System.out.println(l1+" "+l2);
                    if (l1 <= yn && yn <= l2) {
                      //  System.out.println("fuck");
                        b = true;
                        break;
                    }
                }
                boolean b1 = true;
                if(!vis.containsKey(xn) && b){
                    long ar3[] = {xn, yn, dn};
                    q.addLast(ar3);
                    ArrayList<Long> arq= new ArrayList<>();
                    arq.add(yn);
                    vis.put(xn,arq);
                  //  vis.get(yn).add(xn);

                }
                else if(vis.containsKey(xn)){



                ArrayList<Long> a = vis.get(xn);
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(j) == yn) {
                        b1 = false;
                        break;
                    }

                }

                if (b && b1) {

                    long ar3[] = {xn, yn, dn};
                    q.addLast(ar3);
                    vis.get(xn).add(yn);

                }

            }}














        }













    }

return -1;
}

public static ArrayList<String> getpath(int curr,int end){
        if(curr>end){
            ArrayList<String> arr= new ArrayList<>();
            return arr;
        }
        else if(curr==end){
            ArrayList<String> arr= new ArrayList<>();
            arr.add("");
            return arr;
        }


        ArrayList<String> myarr= new ArrayList<>();
            for (int i = 1; i <=6 ; i++) {
                ArrayList<String> rarr= getpath(curr+i,end);
                for (int j = 0; j <rarr.size() ; j++){
                    String str= rarr.get(j);
                    String str1=i+str;
                    myarr.add(str1);
                }
            }























return myarr;}




    static long fc(long n) {
long count=0;
        for (int i = 1; i <=n ; i++) {
            if(n%i==0){
                count++;
        }}
return count;
    }























       static long pow(long b, long p,long m){
        if(p==0){
            return 1;
        }

        long sq= pow(b,p/2,m)%m;
        sq=(sq*sq)%m;
        if(p%2!=0){
            sq=(sq*b)%m;
        }
return sq;









        }













    public static char[] getCharArray(char[] array) {
        String _array = "";
        for(int i = 0; i < array.length; i++) {
            if(_array.indexOf(array[i]) == -1) // check if a char already exist, if not exist then return -1
                _array = _array+array[i];      // add new char
        }
        return _array.toCharArray();
    }










    static void merge(long arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        long L[] = new long [n1];
        long R[] = new long [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(long arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    static boolean ans(int check, long arr[],int n,int med,int k){
        long ans=0;
        for (int i = med; i <n ; i++) {
            if(check>=arr[i]){
                ans+=check-arr[i];
            }
        }
        return ans<=k;




    }


    static boolean isPrime(long n)
    {
        // Corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }






    static   int partition(double arr[],int arr1[],int arr2[], int low, int high)
    {
        double pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                int temp1=arr1[i];
                arr1[i]=arr1[j];
                arr1[j]=temp1;
                int temp2=arr2[i];
                arr2[i]=arr2[j];
                arr2[j]=temp2;

            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        int temp1= arr1[i+1];
        arr1[i+1]=arr1[high];
        arr1[high]= temp1;
        int temp2= arr2[i+1];
        arr2[i+1]=arr2[high];
        arr2[high]= temp2;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(double arr[],int arr1[],int arr2[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr,arr1,arr2, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr,arr1,arr2, low, pi-1);
            sort(arr,arr1, arr2,pi+1, high);
        }
    }
    static int removeDuplicates(int arr[], int n)
    {
        // Return, if array is empty
        // or contains a single element
        if (n==0 || n==1)
            return n;

        int[] temp = new int[n];

        // Start traversing elements
        int j = 0;
        for (int i=0; i<n-1; i++)
            // If current element is not equal
            // to next element then store that
            // current element
            if (arr[i] != arr[i+1])
                temp[j++] = arr[i];

        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        temp[j++] = arr[n-1];

        // Modify original array
        for (int i=0; i<j; i++)
            arr[i] = temp[i];

        return j;
    }
    static long maxPrimeFactors( long n)
    {
        // Initialize the maximum prime
        // factor variable with the
        // lowest one
        long maxPrime = -1;

        // Print the number of 2s
        // that divide n
        while (n % 2 == 0) {
            maxPrime = 2;

            // equivalent to n /= 2
            n >>= 1;
        }

        // n must be odd at this point,
        // thus skip the even numbers
        // and iterate only for odd
        // integers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        // This condition is to handle
        // the case when n is a prime
        // number greater than 2
        if (n > 2)
            maxPrime = n;

        return maxPrime;
    }




}