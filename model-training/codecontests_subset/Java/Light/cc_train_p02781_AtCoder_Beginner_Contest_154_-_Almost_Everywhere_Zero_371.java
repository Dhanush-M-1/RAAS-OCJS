import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] c = s.toCharArray();
        int l = s.length();
        int [] num = new int[l];
        for(int i=0; i<l; i++) {
            num[i] = c[i] - '0';
        }
        int k = sc.nextInt();
        long res = comb(l-1, k) * pow(9, k);

        if(k == 1) {
            res += num[0];
        } else if (k==2 && l >= 2) {
            res += find(num, l, 1, 1) + (num[0]-1) * (l-1) * 9;
        } else if (k==3 && l >=3 ) {
            res += find(num, l, 2, 1) + (num[0]-1) * comb(l-1, 2) * 81;

        }
        System.out.println(res);
    }

    static long find(int[] num, int l, int k, int pos) {
        if(k==0) return 1;
        if(pos + k > l) return 0;
        if(num[pos] == 0) {
            return find(num, l, k, pos+1);
        } else {
            if(k==1) {
                return num[pos] + (l-pos-1) * 9;
            } else {
                return comb(l-pos-1, 2) * 81 + find(num, l, k-1, pos+1) + (num[pos]-1) * comb(l-pos-1, k-1) * pow(9, k-1) ;
            }
        }
    }

    static long comb(int n, int k) {
        if(k == 1) {
            return n;
        }
        if(k == 2) {
            return n * (n-1) / 2;
        }
        return n * (n-1) * (n-2) / 6;
     }

     static long pow(int n, int k) {
        long res = 1;
        for(int i=0; i<k; i++) {
            res *= n;
        }
        return res;
     }

}


