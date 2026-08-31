    import java.util.*;
    import java.io.*;
     
    public class solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int c3 = Integer.parseInt(st.nextToken());
            int c4 = Integer.parseInt(st.nextToken());
            int c5 = Integer.parseInt(st.nextToken());
            long sum = c1 + c2 + c3 + c4 + c5;
            if (sum != 0 && sum % 5 == 0) {
                System.out.println(sum / 5);
            } else
                System.out.println(-1);
        }
     
        static class sort implements Comparator<ArrayList<Integer>> {
     
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int c = o1.get(0).compareTo(o2.get(0));
                return c;
            }
     
        }
    }