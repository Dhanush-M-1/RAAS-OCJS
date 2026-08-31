import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        int s = x.nextInt();
        int prime = 0;
        for(int i=0;i<s;i++){
            if(Prime(x.nextInt())){
                prime++;
            }
        }
        System.out.println(prime);
    }
    public static boolean Prime(int p){
        boolean P =true;
        if(p<2){
            return false;
        }else{
            for(int i=2;i<=Math.sqrt(p);i++){
                if(p%i==0){
                    P = false;
                    break;
                }
            }
        }
        return P;
    }
}
