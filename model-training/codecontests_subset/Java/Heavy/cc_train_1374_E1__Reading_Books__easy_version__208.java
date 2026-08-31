import java.util.*;
import java.io.*;

public class Main{

        public static void main (String[] args) throws IOException {
            StringBuilder sb = new StringBuilder("");
            StringTokenizer st;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                int a[][] = new int[n][3];
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    a[i][0] = Integer.parseInt(st.nextToken());
                    a[i][1] = Integer.parseInt(st.nextToken());
                    a[i][2] = Integer.parseInt(st.nextToken());
                }
            System.out.println(Code(a , n , k));
        }

        static int Code(int a[][] , int n , int k) {
            int maxSum = 0;
            for(int i = 0 ; i < n ; i++) {
                maxSum += a[i][0];
            }
            ArrayList<Integer> both = new ArrayList<Integer>();
            ArrayList<Integer> first = new ArrayList<Integer>();
            ArrayList<Integer> second = new ArrayList<Integer>();
            for(int i = 0 ; i < n ; i++) {
                if(a[i][1] == 0 && a[i][2] == 0) {
                    continue;
                }
                else if(a[i][1] == 1 && a[i][2] == 1) {
                    both.add(a[i][0]);
                }
                else {
                    if(a[i][1] == 1) {
                        first.add(a[i][0]);
                    }
                    else {
                       second.add(a[i][0]);
                    }
                }
            }
            Collections.sort(both);
            Collections.sort(first);
            Collections.sort(second);
            //System.out.println(both);
            //System.out.println(first);
            //System.out.println(second);
            boolean got = false;
            int time = 0;
            int count = 0;
            int pboth = 0 , pfirst = 0 , psecond = 0;
            while(pboth < both.size() || pfirst < first.size() && psecond < second.size()) {
                if(pboth >= both.size()) {
                    time += first.get(pfirst) + second.get(psecond);
                    pfirst++;
                    psecond++;
                    count++;
                }
                else if(!(pfirst < first.size() && psecond < second.size())) {
                    time += both.get(pboth);
                    pboth++;
                    count++;
                }
                else if(both.get(pboth) < first.get(pfirst) + second.get(psecond)) {
                    time += both.get(pboth);
                    pboth++;
                    count++;
                }
                else {
                    time += first.get(pfirst) + second.get(psecond);
                    pfirst++;
                    psecond++;
                    count++;
                }
                if(count == k) {
                    got = true;
                    break;
                }
            }
            //System.out.println(time + " " + count);
            if(got) {
                return time;
            }
            else {
                return -1;
            }
        }

    }
/*
5
4 3
1 2 1 3
10 6
8 7 1 8 3 7 5 10 8 9
5 10
20 100 50 20 100500
10 25
24 24 24 24 24 24 24 24 24 24
8 8
1 2 3 4 5 6 7 8

 */