import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int opt = 0;
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            boolean check = true;
            for(int j=2;j<=Math.sqrt(num);j++){
                if(num%j==0){
                    check=false;
                    break;
                }
            }
            if(check==true) opt++;
        }
        System.out.println(opt);
    }
}
