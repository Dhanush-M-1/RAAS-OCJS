import java.util.*;
import java.io.*;

public class Codeforces {

    
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        HashMap<String, Integer> map = new HashMap();
        String line = Reader.next();
        String arr[] = line.split("-");
        int days[] = {31,28,31,30,31,30,31,31,30,31,30,31}, max = 0;
        
        for(int i = 0; i < arr.length - 2; i++){
            if(arr[i].length() < 2 || arr[i+1].length() < 2 || arr[i+2].length() < 4)
                continue;
            
            int day = Integer.parseInt(arr[i].substring(arr[i].length() - 2));
            int mon = Integer.parseInt(arr[i+1].substring(arr[i+1].length() - 2));
            int year = Integer.parseInt(arr[i + 2].substring(0, 4));
            
            if(year < 2013 || year > 2015)
                continue;
            if(mon > 12 || mon < 1)
                continue;
            if(day > days[mon - 1] || day < 1)
                continue;
           
            String date = arr[i].substring(arr[i].length() - 2) + "-" + arr[i+1].substring(arr[i+1].length() - 2) + "-" + year;
            Integer c = map.get(date);
            
            if(c == null){
                map.put(date, 0);
                c = 0;
            }
            max = Math.max(++c, max);
            map.put(date, c);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                System.out.println(entry.getKey());
                return;
            }
        }
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