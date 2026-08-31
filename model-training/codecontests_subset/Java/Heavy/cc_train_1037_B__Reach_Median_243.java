import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Main {
    static long [] dp = new long[100000];
    static {
        dp[0] = 1;
        dp[1] = 1;
    }

    public static void main(String[] args) throws IOException{
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        InputReader.OutputWriter out = new InputReader.OutputWriter(outputStream);


        int n = in.nextInt();
        int s =  in.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int med = a.length/2;
        long diff = 0;
        if(s<a[med]) {
            diff+=(long)(a[med] -s);
            for (int i = med - 1; i >=0 ; i--) {
                if(a[i]>s) diff+=(long)Math.abs(s-a[i]);
                else break;
            }
        }
        else {
            diff+=(long)(s-a[med]);
            for (int i = med + 1; i < a.length; i++) {
                if(a[i] <s ) {
                    diff+=(long)Math.abs(s-a[i]);
                }
                else break;
            }
        }
        out.println(diff);
        out.flush();

    }
    public static int longestSubsequenceLength(int [] a) {
        int [] dp = new int[a.length];
        for(int i=0;i<a.length;i++) {
            int current = a[i];
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(current>a[j]) {
                    dp[i]=dp[j] + 1;
                }
            }
        }
        int max = dp[0];
        for(int i=1;i<dp.length;i++) {
            if(dp[i]>max) max = dp[i];
        }
        return max;
    }
    public static int reversePairs(int[] a) {
        TreeMap<Long,Integer> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            long current = (long)a[i];
            long higher = (2*current);
            System.out.println(higher);
            Long key = map.higherKey(higher);
            if(key != null) {
                Set<Long> set = map.descendingKeySet();
                Iterator<Long> it = set.iterator();
                while (it.hasNext()) {
                    long t = it.next();
                    if(t>=key) count+=map.get(t);
                    else break;
                }
            }
            map.put((long)a[i],map.getOrDefault((long)a[i],0) + 1 );
        }
        return count;
    }
    private static int lower_bound(int [] a, int target) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo<=hi) {
            int med = hi -(hi-lo)/2;
            if(target == a[med]) return med;
            else if(target > a[med]) lo = med + 1;
            else hi = med - 1;
        }
        return lo;
    }
    private static char [] reverseCharArray(char [] c){
        reverseAnArray(c,0,c.length - 1);
        ArrayList<Integer> spaceIndexes = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if(Character.isWhitespace(c[i])) {
                spaceIndexes.add(i);
            }
        }
        for (int i = 0; i < spaceIndexes.size(); i++) {
            int currentIndex = spaceIndexes.get(i);
            if(i == 0) {
                reverseAnArray(c,0,currentIndex - 1);
            }
            else if (i == spaceIndexes.size() - 1) {
                reverseAnArray(c,currentIndex + 1,c.length - 1);
            }
            else {
                int previousIndex = spaceIndexes.get(i - 1);
                reverseAnArray(c, previousIndex+ 1,currentIndex -1);
            }
        }
        return c;
    }
    private static void reverseAnArray(char [] c, int l ,int r) {
        int i = l;
        int j = r;
        while (i<j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] =temp;
            i++;
            j--;
        }
    }

    private static long sum(int [] a, int f, int l, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = f; i <=l; i++) {
            queue.add(a[i]);
        }
        int [] b = new int[queue.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = queue.poll();
        }
        long sum = 0;
        for (int i = b.length - 1; i >=0; i--) {
            sum+=b[i];
            k--;
            if(k==0) break;
        }
        return sum;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            String isContains = isContains(map.keySet(),s);
            if(isContains!=null) {
                List<String> values = map.get(isContains);
                values.add(s);
                map.put(isContains,values);
            }
            else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(s,temp);
            }
        }
        for (Map.Entry<String,List<String>> m:map.entrySet()) {
            list.add(m.getValue());
        }
        return list;
    }
    private static String isContains(Set<String> set, String a) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            if(areAnagrams(temp,a)) return temp;
        }
        return null;
    }
    private static boolean areAnagrams(String a, String b) {
        int [] freqA = frequency(a);
        int [] freqB = frequency(b);
        for (int i = 0; i < freqA.length; i++) {
            if(freqA[i]!=freqB[i]) return false;
        }
        return true;
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;

        int firstHeater = heaters[0];
        int lastHeader = heaters[heaters.length - 1];

        max = Math.max(firstHeater-houses[0],houses[houses.length-1]-lastHeader);

        for (int i = 0; i < heaters.length - 1; i++) {
            int current = heaters[i];
            int next = heaters[i+1];
            int firstIndex = customBinary(houses,current);
            int secondIndex = customBinary(houses,next);
            int diff = Integer.MAX_VALUE;
            for (int j = firstIndex; j < secondIndex; j++) {
                int fDiff = houses[j] - current;
                int sDiff = next - houses[j];
                if(Math.abs(fDiff-sDiff)<diff) {
                    diff = Math.abs(fDiff-sDiff);
                    min = Math.min(fDiff,sDiff);
                }
            }
            max = Math.max(min,max);
        }
        return max;
    }
    private static int customBinary(int [] a, int target) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo<=hi) {
            int med = lo + (hi - lo)/2;
            if(a[med] == target) return med;
            if(target>a[med]) lo = med + 1;
            else hi = med - 1;
        }
        return lo;
    }

    private static boolean solve(TreeMap<Integer,Integer> map) {
        Integer [] a = map.keySet().toArray(new Integer[0]);
        Integer [] b = map.values().toArray(new Integer[0]);

        for (int i = 0; i < a.length -  1; i++) {
            if(a[i]<a[i+1] && b[i]>b[i+1]) {
                return true;
            }
        }
        return false;
    }

    private static long factorial(int n) {
        if(n<=1) return 1;
        if(dp[n]!=0) return dp[n];
        dp[n] = dp[n-1]*n;
        return dp[n];
    }
    static int factorialZeros(int n) {
        int count = 0;
        for (int i = 5; n/i>=1 ; i*=5) {
            count+=n/i;
        }
        return count;
    }



    public static void swap(int [] a) {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }
    private static boolean isPalindrome(String S) {
        char [] c = S.toCharArray();
        for (int i = 0; i < c.length/2; i++) {
            if(c[i]!=c[c.length - 1 - i]) return false;
        }
        return true;
    }
    static  long maximumSum(long[] a) {
        long max = a[0];
        long localMax = max;

        for (int i = 1; i < a.length; i++) {
            localMax = Math.max(a[i],(localMax + a[i]));
            max = Math.max(max,localMax);
        }

        return max;
    }

    private static int [] prefix (int [] a) {
        int [] prefix = new int[a.length];
        prefix[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }
        return prefix;
    }



    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        char [] s = secret.toCharArray();
        char [] g = guess.toCharArray ();
        HashSet<Integer> indexes = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            if(s[i]==g[i]) {
                indexes.add(i);
                a++;
            }
        }
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> gMap = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if(!indexes.contains(i)) {
                Integer value = sMap.get(s[i]);
                sMap.put(s[i], value == null ? 1 : ++value);
            }
        }
        for (int i = 0; i < g.length; i++) {
            if(!indexes.contains(i)) {
                Integer value = gMap.get(g[i]);
                gMap.put(g[i], value == null ? 1 : ++value);
            }
        }

        for (Map.Entry<Character,Integer> m : sMap.entrySet()) {
            char key = m.getKey();
            if(gMap.containsKey(key)) {
                b+=Math.min(m.getValue(),gMap.get(key));
            }
        }

        return a+"A"+b+"B";
    }

    private static String formNewString(HashSet<Character> set) {
        Iterator<Character> it = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public int minDistance(String word1, String word2) {
        int max = Integer.MIN_VALUE;
        if(word1.length()>word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                for (int j = i+1; j < word1.length(); j++) {
                    String temp = word1.substring(i,j);
                    if(word2.contains(temp)) {
                        int l = word1.length() - temp.length() + word2.length() - temp.length();
                        max = Math.max(max,l);
                    }
                }
            }
            return max;
        }
        else {
            for (int i = 0; i < word2.length(); i++) {
                for (int j = i+1; j < word2.length(); j++) {
                    String temp = word2.substring(i,j);
                    if(word1.contains(temp)) {
                        int l = word2.length() - temp.length() + word1.length() - temp.length();
                        max = Math.max(max,l);
                    }
                }
            }
        }
        return 0;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            Integer value = map.get(deck[i]);
            map.put(deck[i], value == null ? 1 : ++value);
        }
        int gcd = 0;
        for (Map.Entry<Integer,Integer> m:map.entrySet()) {
            gcd = gcd(gcd,m.getValue());
        }
        return gcd > 1;
    }
    private static int gcd(int a,int b) {
        return b==0 ? a : gcd(b,a%b);
    }


    static boolean isSh(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n>0) {
            int k = n%10;
            if(k!= 3 && k!=5 && k!=7) return false;
            set.add(k);
            n/=10;
        }
        return set.size() == 3;
    }
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1 = sumOfArray(h1,0);
        int sum2 = sumOfArray(h2,0);
        int sum3 = sumOfArray(h3,0);

        if(sum1==sum2 && sum2==sum3) return sum1;

        int index = 0;

        while (sum1!=sum2 && sum2!=sum3) {

        }

        return 0;
    }

    static int sumOfArray(int [] a,int index) {
        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum+=a[i];
        }
        return sum;
    }

    public boolean checkInclusion(String s1, String s2) {
        int [] mainFreq = frequency(s1);
        int length = s1.length();
        for (int i = 0; i <=s2.length() - length; i++) {
            String temp = s2.substring(i,length+i);
            int [] freq = frequency(temp);
            boolean check = checkFrequencies(mainFreq,freq);
            if(check) return true;
        }
        return false;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int [] mainFreq = frequency(p);
        int length = p.length();

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i <=s.length()-length; i++) {
            String temp = s.substring(i,length+1);
            int [] freq = frequency(temp);
            if(checkFrequencies(freq,mainFreq)) indexes.add(i);
        }
        return indexes;
    }
    private static boolean checkFrequencies(int [] freqA, int [] freqB) {
        for (int i = 0; i < freqA.length; i++) {
            if(freqA[i]!=freqB[i]) return false;
        }
        return true;
    }

    private static int [] frequency(String s) {
        int [] freq = new int[26];
        for (char c:s.toCharArray()) {
            freq[c-'a']++;
        }
        return freq;
    }
    static int lowerBound(int [] a, int target) {
        int lo = 0;
        int hi = a.length - 1;
        int ans = -1;

        while (lo<=hi) {
            int med = hi - (hi-lo)/2;
            if(target == a[med]){
                ans = med;
                hi = med - 1;
            }
            else if(target < a[med])  hi = med - 1;
            else lo = med + 1;
        }
        return ans;
    }


    static int upperBound(int [] a, int target) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo<=hi) {
            int med = hi-(hi-lo)/2;
            if(target>=a[med]) lo = med + 1;
            else hi = med - 1;
        }
        return hi;
    }
    static boolean isPrime(int n) {
        if(n<=2) return false;
        for (int i = 2; i*i <=n ; i++) {
            if(n%i==0) return  false;
        }
        return  true;
    }
}

class Pair {
    private int left;
    private int rigth;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRigth() {
        return rigth;
    }

    public void setRigth(int rigth) {
        this.rigth = rigth;
    }

    public Pair(int left, int rigth) {
        this.left = left;
        this.rigth = rigth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return left == pair.left &&
                rigth == pair.rigth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, rigth);
    }

    @Override
    public String toString() {
        return  "left=" + left +
                ", rigth=" + rigth +
                '}';
    }
}


class InputReader extends BufferedReader {
    StringTokenizer tokenizer;

    public InputReader(InputStream inputStream) {
        super(new InputStreamReader(inputStream), 32768);
    }

    public InputReader(String filename) {
        super(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(readLine());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return tokenizer.nextToken();
    }

    public Integer nextInt() {
        return Integer.valueOf(next());
    }
    public Long nextLong() {return  Long.valueOf(next());}

    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream outputStream) {
            super(outputStream);
        }

        public OutputWriter(Writer writer) {
            super(writer);
        }

        public OutputWriter(String filename) throws FileNotFoundException {
            super(filename);
        }

        public void close() {
            super.close();
        }
    }
}