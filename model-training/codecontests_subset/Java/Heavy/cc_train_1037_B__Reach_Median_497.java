import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();
        Integer[] smallList = new Integer[n];
        Integer[] bigList = new Integer[n];
        int smallListCnt = 0;
        int bigListCnt = 0;
        boolean haveTarget = false;

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int subVal = value-target;
            smallList[i] = 0;
            bigList[i] = 0;
            if (subVal==0 && !haveTarget) {
                haveTarget = true;
            } else if (subVal < 0) {
                smallList[i] = -subVal;
                smallListCnt++;
            } else {
                bigList[i] = subVal;
                bigListCnt++;
            }
        }

        if (haveTarget) {
            if (smallListCnt==bigListCnt) {
                System.out.print(0);
            } else if (smallListCnt>bigListCnt) {
                Arrays.sort(smallList);
                long smallListSum = 0;
                for (int i=n-smallListCnt;i<n-smallListCnt+(smallListCnt-bigListCnt)/2;i++) {
                    smallListSum += smallList[i];
                }
                System.out.print(smallListSum);
            } else {
                Arrays.sort(bigList);
                long bigListSum = 0;
                for (int i=n-bigListCnt;i<n-bigListCnt+(bigListCnt-smallListCnt)/2;i++) {
                    bigListSum += bigList[i];
                }
                System.out.print(bigListSum);
            }
        } else {
            if (smallListCnt>bigListCnt) {
                Arrays.sort(smallList);
                long smallListSum = 0;
                for (int i=n-smallListCnt;i<n-smallListCnt+(smallListCnt-bigListCnt+1)/2;i++) {
                    smallListSum += smallList[i];
                }
                System.out.print(smallListSum);
            } else {
                Arrays.sort(bigList);
                long bigListSum = 0;
                for (int i=n-bigListCnt;i<n-bigListCnt+(bigListCnt-smallListCnt+1)/2;i++) {
                    bigListSum += bigList[i];
                }
                System.out.print(bigListSum);
            }
        }
    }
}
 	  		 			 		  		  	 	  		 	