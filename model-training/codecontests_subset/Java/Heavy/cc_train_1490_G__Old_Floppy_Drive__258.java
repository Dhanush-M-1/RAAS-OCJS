//package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Codeforces702Div2_G {

    public static int binarySearch(Long prefexSum[], int N, Long x) {
        int ans = N;
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + ((end - start) / 2));
            if (prefexSum[mid] >= x) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Long arr[] = new Long[n];
            Long prefixSum[] = new Long[n];
            //prefixSum.add(0);
            Long sum = 0l;
            st = new StringTokenizer(br.readLine());
            Long max = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {

                arr[i]=Long.parseLong(st.nextToken());
                sum += arr[i];
                max = Math.max(max, sum);
                prefixSum[i]=max;
            }

            Long arrM[] = new Long[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arrM.length; i++) {
                arrM[i] = Long.parseLong(st.nextToken());

                if (max>=arrM[i]){
                    System.out.print(binarySearch(prefixSum,n,arrM[i])+" ");
                }else if (sum<=0){
                    System.out.print(-1+" ");
                }else {
                    Long temp= arrM[i]-max;
                    Long ans=(temp+sum-1)/sum;
                    arrM[i]-=(ans*sum);
                    ans*=n;
                    ans+=binarySearch(prefixSum,n,arrM[i]);
                    System.out.print(ans+ " ");

                }
//                if (arrM[i]>0 && sum<0){
//                    System.out.print(-1+" ");
//                }else if (arr.contains(arrM[i])){
//                    System.out.print(arr.indexOf(arrM[i])+" ");
//                }else if (sum<arrM[i]) {

//
//                    if (prefixSum.contains(diff)) {
//                        int index = prefixSum.indexOf(diff);
//
//                        System.out.print(passes * arr.size() + index - 1 + " ");
//                    } else {
//                        System.out.print(-1);
//                    }
//                }else if (sum==arrM[i]){
//                    System.out.print(arr.size()-1+" ");
//                }

            }


                System.out.println();

            }
        }
}

