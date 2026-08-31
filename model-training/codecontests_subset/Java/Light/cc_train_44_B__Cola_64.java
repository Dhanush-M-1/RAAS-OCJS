import java.util.Scanner;


public class B {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), a = in.nextInt(), b= in.nextInt() , c= in.nextInt();
        in.close();
        long sum = 0;
        for(int i = 0 ; i<=c ; i++){
            for(int j = 0 ; j<=b ; j++){
                int t = (n - (i*2 + j))*2;
                if(t >=0 && t<=a){
                    //System.out.println(i+","+j+","+t);
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
