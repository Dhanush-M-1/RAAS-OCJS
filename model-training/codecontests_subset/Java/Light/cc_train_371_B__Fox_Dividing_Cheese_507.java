import java.util.*;
public class Ladder {
    public static int[] factorization(int a){
        int temp[] = new int[4];
        while (true) {            
            if(a%5==0){
                a/=5;
                temp[2]++;
            }else if(a%3==0){
                a/=3;
                temp[1]++;
            }else if(a%2==0){
                a/=2;
                temp[0]++;
            }else{
                break;
            } 
        }
        temp[3]=a;
        return temp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int aex[]=new int[4];
        int bex[]=new int[4];
        aex = factorization(a);
        bex = factorization(b);
        if(aex[3]!=bex[3]){
            System.out.println("-1");
        }else{
            System.out.println(Math.abs(aex[0]-bex[0])+Math.abs(aex[1]-bex[1])+Math.abs(aex[2]-bex[2]));
        }
    }
}
