import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0)break;
            boolean f = true;
            int c = 0;
            int ans=0;
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                int add = 0;
                if(s.charAt(0)=='l'){
                    add=1;
                } else {
                    add=2;
                }
                if(s.charAt(1)=='u'){
                    c+=add;
                } else {
                    c-=add;
                }
                if(c==3){
                    if(f)ans++;
                    f=false;
                    
                }
                if(c==0){
                    if(!f)ans++;
                    f=true;
                    
                }
            }
            System.out.println(ans);
        }
    }

}