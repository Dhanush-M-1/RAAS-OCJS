
    import java.util.*;
    import java.io.*;

    public class Codeforces {


        public static void main(String[] args) throws IOException {
            Reader.init(System.in);
            String a = Reader.next(), b = Reader.next(), c = Reader.next();
            int[] freq = new int[26], arr1 = new int[26], arr2 = new int[26];
            
            getQ(freq, a);
            getQ(arr1, b);
            getQ(arr2, c);
            
            int x = getMin(freq, arr1);
            int k1 = 0, k2 = 0, max = Integer.MIN_VALUE;
            
            for(int i = 0; i <= x; i++){
                int z = delet(freq, arr1, arr2, i);
                
                if(max < i + z){
                    k1 = i; k2 = z;
                    max = i+z;
                }
            }
            
            StringBuilder ans = new StringBuilder();
            int arr3[] = new int[26];
            
            while(k1 != 0){
                ans.append(b);
                k1--;
            }
            
            while(k2 != 0){
                ans.append(c);
                k2--;
            }
            
            getQ(arr3, ans.toString());
            
            for(int i = 0; i < 26; i++){
                if(freq[i] != 0){
                    freq[i] -= arr3[i];
                    char ch = (char)(97+i);
                    
                    while(freq[i] != 0){
                       ans.append(ch);
                       freq[i]--;
                    }
                }
            }
            
            System.out.println(ans);
        }
        
        public static int getMin(int freq[], int arr[]){
            int min = 999999999;
            
            for(int i = 0; i < freq.length; i++){
                if(arr[i] != 0 && min > (freq[i]/arr[i]))
                    min = freq[i] / arr[i];
            }
            
            if(min == 999999999)
                min = 0;
            
            return min;
        }
        
        public static int delet(int freq[], int arr1[], int arr2[], int min){
            
            int copy[] = new int[26];
            for(int i = 0; i  < 26; i++)
                copy[i] = freq[i];
            
            for(int i = 0; i < 26; i++){
                if(arr1[i] != 0)
                    copy[i] -= arr1[i] * min;
            }
            
            return getMin(copy, arr2);
        }
        
        public static void getQ(int arr[], String a){
            for(int i = 0; i < a.length(); i++)
                arr[a.charAt(i) - 'a']++;
        }
    }

    class Reader {

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

        static byte nextByte() throws IOException {

            return Byte.parseByte(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
