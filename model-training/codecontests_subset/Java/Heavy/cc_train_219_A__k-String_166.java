

// Working program with FastReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args)
    {
        FastReader fastReader = new FastReader();

        long k = fastReader.nextLong();

        String string = fastReader.nextLine();

        Map<Character , Long> characterCounter = new HashMap<>();

        for(long i=0 ; i<string.length() ; i++){

            char character = string.charAt((int) i);

            if(characterCounter.containsKey(character)){

                characterCounter.put(character , characterCounter.get(character) + 1);

            }

            else {

                characterCounter.put(character , 1L);

            }

        }

        boolean possible = true;

        for(Map.Entry<Character , Long> entry : characterCounter.entrySet()){

            if( ( ( entry.getValue() ) % k ) !=0){

                System.out.println(-1);

                possible = false;

                break;
            }

        }

        if(possible){

            StringBuilder stringBuilder = new StringBuilder();

            for(Map.Entry<Character , Long> entry : characterCounter.entrySet()){

                long frequencyInEachRepeat = entry.getValue() / k;

                for(long i=0 ; i<frequencyInEachRepeat ; i++){

                    stringBuilder.append(entry.getKey());

                }

            }

//            System.out.println("String to be repeated: " +stringBuilder.toString() );

            StringBuilder finalStringBuilder = new StringBuilder();

            for(long i=0 ; i<k ; i++){

                finalStringBuilder.append(stringBuilder.toString());

            }

            System.out.println(finalStringBuilder.toString());









        }










    }
}

