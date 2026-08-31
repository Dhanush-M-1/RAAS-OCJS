import java.util.*;

class Main{

    public static void main(String args[]) throws Exception{
        Main main = new Main();
    }

    public Main(){
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int K = scanner.nextInt();
        int L = N.length();

        long[] D = new long[L];
        for(int i=0;i<L;i++) D[i] = (long)Character.getNumericValue(N.charAt(i));

        long R = 0;
        int i=0;
        while(K>0 && L>i){
            if(K > L-i) break;

            if(K == 1){
                if(D[i] != 0){
                    R += D[i];
                    R += 9L * (L-(long)i-1L);
                    K--;
                }
            } else if(K == 2){
                if(D[i] != 0){
                    R += (D[i]-1L) * 9L * (L-(long)i-1L);
                    R += 81L * (L-(long)i-1L) * (L-(long)i-2L) /2L;
                    K--;
                }
            } else {
                R += (D[0]-1L) * 81L * (L-1L) * (L-2L) / 2L;
                R += 729L * (L-1L) * (L-2L) * (L-3L) / 6L;
                K--;
            }

            i++;
        }

        System.out.println(R);
    }
}
