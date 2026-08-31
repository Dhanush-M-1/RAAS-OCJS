import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k=s.nextInt();
        while (k>0){
            k--;
            int a=s.nextInt();
            int b=s.nextInt();
            int f=-1;
            ArrayList<Integer> c=new ArrayList<>();
            boolean ans=false;
            for (int i=0;i<a;i++){
                c.add(s.nextInt());
            }
            for (int i=0;i<b;i++){
                int d=s.nextInt();
                for (int j=0;j<a;j++){
                    if (ans){
                        break;
                    }
                    if (d==c.get(j)){
                        f=d;
                        ans=true;
                    }
                }
            }
            if (ans){
                System.out.println("YES");
                System.out.println(1+" "+f);
            } else {
                System.out.println("NO");
            }

        }

    }
}