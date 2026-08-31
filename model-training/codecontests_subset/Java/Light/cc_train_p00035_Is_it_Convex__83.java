import java.util.*;

class Main{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                while(sc.hasNext()){
                        double[][] x = new double[4][2];
                        String[] s = sc.nextLine().split(",");
                        for(int i = 0; i < 4; i++){
                                for(int j = 0; j < 2; j++){
                                        x[i][j] = Double.parseDouble(s[i*2+j]);
                                }   
                        }   
                        System.out.println(judge(x) ? "YES": "NO");
                }   
                sc.close();
        }   
        static boolean vp(double[][] x){
                return (x[2][0]-x[1][0])*(x[3][1]-x[2][1])-(x[2][1]-x[1][1])*(x[3][0]-x[2][0]) > 0;
        }   
        static boolean judge(double[][] x){
                boolean flag = vp(x);
                for(int i = 0; i < 3; i++){
                        shift(x);
                        if(flag != vp(x)){
                                return false;
                        }   
                }   
                return true;
        }   
        static void shift(double[][] x){
                double[] _x = {x[3][0], x[3][1]};
                for(int i = 3; i > 0; i--){
                        x[i][0] = x[i-1][0];
                        x[i][1] = x[i-1][1];
                }   
                x[0][0] = _x[0];
                x[0][1] = _x[1];
        }   
}