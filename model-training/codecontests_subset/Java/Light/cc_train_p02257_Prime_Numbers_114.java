import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),count=0;
        for(int ii=0;ii<n;ii++){
            int k = sc.nextInt();
            boolean flg = true;
            for(int i=2;i<=Math.sqrt(k);i++){
                if(k%i==0){flg=false;break;}
            }
            if(flg){
                count++;
            }
        }
        System.out.println(count);
    }
}
