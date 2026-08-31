import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l; int m; int n;
        int savings;
        int month;
        int stop;
        
        while((l=sc.nextInt())!=0){
            savings=0;
            month=0;
            stop=0;
            for(int i=1;i<=12;i++){
                m=sc.nextInt();
                n=sc.nextInt();

                savings+=m-n;
                if(savings>=l && stop==0){ month=i; stop++; }
            }
            if(month!=0){ System.out.println(month); }
            else{ System.out.println("NA"); }

        }
    }
}
