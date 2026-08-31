import java.io.*;

import java.util.*;

public class Codeforce{


    static FastReader fs = new FastReader();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // int t = fs.nextInt();

        // while(t-- >0){

        

        // }
        int a = fs.nextInt(), b = fs.nextInt(),hours=0;
        while(a>=b){
            a -=b;
            hours +=b;
            a++; 
        }
        System.out.println(hours+a);

    }


    static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }

    public static void sieve(int[] arr){
        
        for(int i=2;i<arr.length;i++){
            if(arr[i]==0){
                if((long)i*(long)i>arr.length)break;
                for( int j=i*i;j<arr.length;j+=i){
                    arr[j]=1;
                }
            }
        }
 
    }

    
    public static boolean isPrime(int val){
        int[] arr = new int[1000001];
        sieve(arr);
        if(arr[val]==0) return true;
        return false;

    }

    public static boolean isPrime(long val){
        if(val==1) return false;
        if(val<4) return true;
        if(val%2==0) return false;
        for(long i=3;i*i<=val;i+=2){
            if(val%i==0){
                return false;
            }
        }
        return true;
    }


    public static int isplaindrome(StringBuilder b){
        for(int i=0,g=b.length()-1;i<b.length()/2;i++,g--){
            if(i>=g)break;
            if(b.charAt(i)!=b.charAt(g)){ return i;}
        }
        return -1;
    }

    public static  void sort(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:arr) list.add(i);
        Collections.sort(list);
        int index =0;
        for(int i:list) {arr[index]=i; index++;}
    }

    public static  void sort(char[] arr){
        ArrayList<Character> list = new ArrayList<>();
        for(char i:arr) list.add(i);
        Collections.sort(list);
        int index =0;
        for(char i:list) {arr[index]=i; index++;}
    }

    public static  void sort(long[] arr){
        ArrayList<Long> list = new ArrayList<>();
        for(long i:arr) list.add(i);
        Collections.sort(list);
        int index =0;
        for(long i:list) {arr[index]=i; index++;}
    }

    public static  void reverse(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:arr) list.add(i);
        Collections.sort(list, Collections.reverseOrder());
        int index =0;
        for(int i:list) {arr[index]=i; index++;}
    }

    static public void printArray(int[] arr){
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
        System.out.println();

    }


    static public long max(long[] arr){
        long max = Long.MIN_VALUE;
        for(long l:arr){
            if(l>max) max = l;
        }
        return max;
    }
    static public int min(int[] arr){
        int min = Integer.MAX_VALUE,index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min) {min = arr[i];index=i;}
        }
        return index;
    }
    static public int max(int[] arr){
        int max = Integer.MIN_VALUE,index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) {max = arr[i];index=i;}
        }
        return index;
    }
    

    static public char max(char[] arr){
        char max = Character.MIN_VALUE;
        for(char l:arr){
            if(l>max) max = l;
        }
        return max;
    }
}


class Data implements Comparable<Data>{
    int  x;
    int  a;
    public Data(int x, int a){
        this.x = x;
        this.a = a;
    }
    @Override
    public int compareTo(Data o) {
        if(x>o.x) return 1;
        else if(x<o.x) return -1;
        else return 0;
    }
}

class FastReader{
    private BufferedReader br;
    private StringTokenizer str;

    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String next(){
        while(str==null || !str.hasMoreTokens()){
            try{
                str = new StringTokenizer(br.readLine());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return str.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }

    public long nextLong(){
        return  Long.parseLong(next());
    }

    public double nextDouble(){
        return Double.parseDouble(next());
    }

    public String nextLine(){
        String s = "";
        try{
            s = br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }

        return s;
    }

    public int[] readArray(int n){
        int[] arr = new int[n];
        for(int i =0;i<n;i++) arr[i] = nextInt();
        return arr;
    }

    public long[] readArrayL(int n){
        long[] arr = new long[n];
        for(int i =0;i<n;i++) arr[i] = nextLong();
        return arr;
    }
    public double[] readArrayD(int n){
        double[] arr = new double[n];
        for(int i =0;i<n;i++) arr[i] = nextDouble();
        return arr;
    }

}
