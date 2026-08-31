import java.util.Scanner;

public class problem20B {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double A = (double) (scan.nextInt());
        double B = (double) (scan.nextInt());
        double C = (double) (scan.nextInt());
        scan.close();
        
        int K = -2; //otvet
        double[] roots = new double[1];
        
        if (A == 0 && B == 0 && C == 0) {
            K = -1;
        }
        
        if (K == -2 && ((A!=0 && B==0 && C == 0) ||  (A==0 && B!=0 && C == 0) || (A==0 && B!=0 && C != 0))) {
            K = 1;
            roots = new double[K];
            roots[0] = B == 0 ? 0 : -C / B;
        }
        
        if (K == -2 && A == 0 && B == 0 && C != 0) {
            K = 0;
        }
        
        if (K == -2) {
            double D = B*B - 4*A*C;
            //System.out.println(D+"");
            if (D < 0) 
                K = 0;
            if (D == (double) (0)) {
                //System.out.println("D = " + D);
                K=1;
                roots = new double[K];
                roots[0] = (-B) / (2*A);
            }
            if (D > 0) {
                K=2;
                roots = new double[K];
                roots[0] = ((-B) - Math.sqrt(D)) / (2*A);
                roots[1] = ((-B) + Math.sqrt(D)) / (2*A);
            }
        }
        
        if (K == 2 && roots[0] > roots[1]) {
            double tmp = roots[0];
            roots[0] = roots[1];
            roots[1] = tmp;
        }
            
        
        System.out.println(K);
        for (int i = 0; i<K; i++)
            System.out.println(roots[i]);
        
    }
}