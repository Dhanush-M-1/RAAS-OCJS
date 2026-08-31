 import java.io.*;
        import java.util.*;
        public class Main {
            static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        public static void main(String args[]) throws NumberFormatException, IOException {
            //next<datatype>() for input of a type
            //next<datatyoe>array() for array input of a type
            int t=nextInt();
        int arr[]=nextIntarray();
        int cnt1=0,cnt2=0;
        for(int i=0;i<t;i++){
            if(arr[i]==100)cnt1++;
            else cnt2++;

        }
        if(cnt2%2==0 && cnt1%2==0)System.out.println("YES");
        else if(cnt2%2==1 && cnt1%2==0 && cnt1>0)System.out.println("YES");
       
        else System.out.println("NO");
        }
        

        private static double[] nextDoublearray() throws IOException {
            String s[]=bf.readLine().split(" ");
            double arr[]=new double[s.length];
            for(int i=0;i<s.length;i++){
                arr[i]=Double.parseDouble(s[i]);
            }
            return arr;
        }

        private static double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(bf.readLine());
        }
        
        private static long GCD(long a, long b) {
               if (b==0) return a;
               return GCD(b,a%b);
        }

        private static long[] nextLongarray() throws IOException {
            String s[]=bf.readLine().split(" ");
            long arr[]=new long[s.length];
            for(int i=0;i<s.length;i++){
                arr[i]=Long.parseLong(s[i]);
            }
            return arr;
            }

        private static long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(bf.readLine());
            }

        private static int[] nextIntarray() throws IOException {
            String s[]=bf.readLine().split(" ");
            int arr[]=new int[s.length];
            for(int i=0;i<s.length;i++){
                arr[i]=Integer.parseInt(s[i]);
            }
            return arr;
        }

        private static int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(bf.readLine());
        }
        private static boolean isPalindrome(String s) {

              int n = s.length();
              for (int i=0;i<(n / 2) + 1;++i) {
                 if (s.charAt(i) != s.charAt(n - i - 1)) {
                     return false;
                 }
              }

              return true;
            }
        private static int factorial(int num)
        {
            if (num == 0 || num == 1)
            {
                return 1;
            }
            else
            {
                return(num * factorial(num - 1));
            }
        }
        private static long power(long b,long e){
        if (e == 0) return 1;
                if (e%2==0) return power(b*b, e/2);
                /* e is odd */ return b * power(b, e-1);
        }
        private static long lcm(long a, long b)
        {
            return a * (b / GCD(a, b));
        }
        
        private static boolean isPrimeNumber(long number){
             
                for(long i=2; i<=number/2; i++){
                    if(number % i == 0){
                        return false;
                    }
                }
                return true;
            }
        
        
        
        /*COMBINATION CODE
    void combinationUtil(int arr[], int n, int r, int index, int data[], int i)
{
    // Current cobination is ready, print it
    if (index == r)
    {
        for (int j=0; j<r; j++)
            printf("%d ",data[j]);
        printf("\n");
        return;
    }
 
    // When no more elements are there to put in data[]
    if (i >= n)
        return;
 
    // current is included, put next at next location
    data[index] = arr[i];
    combinationUtil(arr, n, r, index+1, data, i+1);
 
    // current is excluded, replace it with next (Note that
    // i+1 is passed, but index is not changed)
    combinationUtil(arr, n, r, index, data, i+1);

    }
         */
    
        
        //PERMUTATION CODE  
        /*
          
         void permute(char *a, int l, int r)
    {
   int i;
   if (l == r)
     printf("%s\n", a);
   else
   {
       for (i = l; i <= r; i++)
       {
          swap((a+l), (a+i));   
          permute(a, l+1, r);
          swap((a+l), (a+i)); //backtrack
       }
   }
    }*/
public static class Node{
    int x;
    int y;
    Node(int a,int b){
        x=a;y=b;
    }
    
}
        
        }