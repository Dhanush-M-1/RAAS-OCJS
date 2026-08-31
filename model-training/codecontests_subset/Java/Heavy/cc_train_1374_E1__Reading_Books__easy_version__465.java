import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        ArrayList<Integer> alice=new ArrayList<>();
        ArrayList<Integer> bob=new ArrayList<>();
        ArrayList<Integer> both=new ArrayList<>();

        while(n-->0){
            int t=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
            if(a==1 && b==1){
                both.add(t);
            }else if(a==1){
                alice.add(t);
            }else if(b==1)
                bob.add(t);
        }

        if(alice.size()+both.size()<k || bob.size()+both.size() < k){
            System.out.println("-1");
            return;
        }
        Collections.sort(alice);
        Collections.sort(bob);
        Collections.sort(both);
        int w=Math.min(alice.size(),bob.size());
        int res=0,i=0,r=0;
        while(k-->0){
//            if(w==0){
//                res+=both.get(r);
//                r++;continue;
//            }

            if(r<both.size() && i<w && alice.get(i)+bob.get(i)>both.get(r)){
                res+=both.get(r);
                r++;
            }else if(i<w){
                res+=alice.get(i)+bob.get(i);
                i++;
            }else{
                res+=both.get(r);
                r++;
            }
        }

        System.out.println(res);

    }
}
