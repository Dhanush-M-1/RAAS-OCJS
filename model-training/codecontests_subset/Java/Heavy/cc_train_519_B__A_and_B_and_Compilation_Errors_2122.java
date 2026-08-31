//package Mura;
/*****   BY MURAD   ******/
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Code {
    public static int ar[]={5,3,2,1,8,9,12,15,30,22,18,9};
    public static int binarysearch(int []ar,int v,int low,int heig)
    {
        while(low<=heig)
        {
            int mid=(low+heig)/2;
            if(ar[mid]==v)
                return mid/2;
            if(mid>0&&mid+1<ar.length&&ar[mid+1]>v&&ar[mid-1]<v)
                return mid/2;
            if(ar[mid]>v)
            {
                heig=mid-1;
            }
            else
                low=mid+1;
        }
        return 0;
    }
    public static void sort(int arr[], int l, int r)
    {
            if (l < r) {
                // Find the middle point
                int m = (l + r) / 2;
                // Sort first and second halves
                sort(arr, l, m);
                sort(arr, m + 1, r);
                // Merge the sorted halves
                merge(arr, l, m, r);
            }
    }
    public static void merge(int arr[], int low, int mid, int hig)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid-low + 1;
        int n2 = hig - mid;
        /* Create temp arrays */
        int Left[] = new int [n1];
        int Right[] = new int [n2];
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            Left[i] = arr[low + i];
        for (int j=0; j<n2; ++j)
            Right[j] = arr[mid + 1+ j];
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = low;
        while (i < n1 && j < n2)
        {
            if (Left[i] <= Right[j])
            {
                arr[k] = Left[i];
                i++;
            }
            else
            {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = Left[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }
    public static int binary_Insertion_sort(int a[],int item,int low,int heig)
    {
        if(heig<=low)
            return (item>a[low]?(low+1):low);
        int mid=(low+heig)/2;
        if(item==a[mid])
            return mid+1;
        if(item>a[mid])
        {
            return binary_Insertion_sort(a,item,mid+1,heig);
        }
        else
            return binary_Insertion_sort(a,item,low,mid-1);
    }
    public static void insertion_sort(int a[])
    {
        int len=a.length;
        for(int i=1;i<len;i++)
        {
            int key=a[i];
            int j=i-1;
            int loc=binary_Insertion_sort(a,key,0,j);
            while(j>=loc)
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
    }
    public static int GetKthItem(int[] arr1, int[] arr2,int low1 ,int hig1, int low2,int hig2, int k)
    {
        if(hig1<low1)
        {
            return arr2[hig2-k+1];
        }
        if(hig2<low2)
        {
            return arr1[hig1-k+1];
        }
        if(hig1==low1)
        {
            if(k==1)
            {
                return Math.max(arr1[low1],arr2[hig2]);
            }
            else
                return GetKthItem(arr1,arr2,low1,hig1-1,low2,hig2,k-1);
        }
        if(hig2==low2)
        {
            if(k==1)
                return Math.max(arr2[low2],arr1[hig1]);
            else
                return GetKthItem(arr1,arr2,low1,hig1,low2,hig2-1,k-1);
        }
        if(k==1)
            return Math.max(arr1[hig1],arr2[hig2]);
        int m1 = (low1 + hig1) / 2;
        int m2 = (low2 + hig2) / 2;
        if (arr1[m1] <= arr2[m2])
        {
            int check=k-(hig2-m2);
            if(check>=1) {
                return GetKthItem(arr1, arr2, low1, hig1, low2, m2 , k - (hig2 - m2));
            }
            else
               return arr2[hig2-k+1];
        }
        else {
            int check=k-(hig1-m1);
            if(check>=1) {
                return GetKthItem(arr1, arr2, low1, m1 , low2, hig2, k - (hig1 - m1));
            }
            else
                return arr1[hig1-k+1];
        }
    }
    static class DPS {
        public static int []ar={1,2,4,7,9,12,18,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
        String LongestSubPlindrome(String s) {
            int len = s.length();
            if (s == null || len < 2)
                return s;
            boolean table[][] = new boolean[len][len];
            int left = 0, right = 0;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    boolean isplindrome = table[i - 1][j + 1] || i - j <= 2;
                    if (s.charAt(i) == s.charAt(j) && isplindrome) {
                        table[i][j] = true;
                        if (i - j > right - left) {
                            left = j;
                            right = i;
                        }
                    }
                }
            }
            return s.substring(left, right + 1);
        }
        int LIS(int a[],int n) {
            int dp[] = new int[n];
            for (int i = 0; i < dp.length; i++)
                dp[i] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[i] > a[j])
                        dp[i] = dp[i - 1] + 1;
                }
            }
            int max = 0;
            for (int i = 0; i < dp.length; i++)
                if (dp[i] > max)
                    max = dp[i];
            return max;
        }
    }
    public static long mod=998244353;
    public static boolean isPowerOfTwo(int n)
    {
        if (n == 0)
            return false;
        while (n != 1)
        {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }
    public static long GCD(long x,long y){
        if(y==0)
            return x;
        else
            return GCD(y,x%y);
    }
    static class Graph {
        private int v;
        private ArrayList<Integer> adj[];
        Graph(int vv) {
            v = vv;
            adj = new ArrayList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new ArrayList<>();
            }
        }
        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }
    }
    public static void main(String[] args)throws IOException {
        Scanner inp = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        HashSet<Integer>set=new HashSet<>();
        TreeMap<Integer,Integer>tm=new TreeMap<>();
        TreeMap<Integer,Integer>tm2=new TreeMap<>();
        TreeMap<Integer,Integer>tm3=new TreeMap<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            int x=Integer.parseInt(st.nextToken());
            if(!tm.containsKey(x)) {
                tm.put(x, 1);
            }
            else
            {
                Integer freq=tm.get(x);
                tm.put(x,freq+1);
            }
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++)
        {
            int x=Integer.parseInt(st.nextToken());
            if(tm.containsKey(x))
            {
                Integer frq=tm.get(x);
                tm.put(x,frq-1);
                if(tm2.containsKey(x)) {
                    int f=tm2.get(x);
                    tm2.put(x, f+1);
                }
                else
                    tm2.put(x,1);
            }
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n-2;i++)
        {
            int x=Integer.parseInt(st.nextToken());
            if(tm2.containsKey(x))
            {
                Integer frq=tm2.get(x);
                tm2.put(x,frq-1);
            }
        }

        for(Map.Entry<Integer,Integer>entry:tm.entrySet())
        {
            if(entry.getValue()>0)
            {
                System.out.println(entry.getKey());
                break;
            }
        }
        for(Map.Entry<Integer,Integer>entry:tm2.entrySet()){
            if(entry.getValue()>0)
            {
                System.out.print(entry.getKey());
                break;
            }
        }

    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
    static class Pair implements Comparable<Pair> {
        int value, idx;
        Pair(int v, int i)
        {
            value = v;
            idx = i;
        }
        @Override
        public int compareTo(Pair p) {
            return value - p.value;
        }
    }
    public static int[] bctsort(int[] array, int bucketCount) {
        if (bucketCount <= 0) throw new IllegalArgumentException("Invalid bucket count");
        if (array.length <= 1) return array;
        int high = array[0];
        int low = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > high) high = array[i];

            if (array[i] < low) low = array[i];
        }
        double interval = ((double)(high - low + 1))/bucketCount;
        ArrayList<Integer> buckets[] = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {

            buckets[i] = new ArrayList();

        }
        for (int i = 0; i < array.length; i++) {

            buckets[(int)((array[i] - low)/interval)].add(array[i]);
        }
        int pointer = 0;

        for (int i = 0; i < buckets.length; i++) {

            Collections.sort(buckets[i]);

            for (int j = 0; j < buckets[i].size(); j++) {

                array[pointer] = buckets[i].get(j);

                pointer++;

            }
        }
        return array;
    }
    /*
      int maxValueInMap=(Collections.max(mp.values()));  // This will return max value in the Hashmap
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                System.out.println(entry.getKey());
                break;
            }
        }
        Relatively Prime :- if diffrence between two number is equal to 1
    */
}