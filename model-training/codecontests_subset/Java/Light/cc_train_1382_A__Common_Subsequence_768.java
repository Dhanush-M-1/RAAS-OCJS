import java.util.*;
public class ArraySub {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        long t=0,m=0,n=0;
        t = input.nextLong();
        for(int i=0;i<t;i++){
            m = input.nextLong();
            n = input.nextLong();
            ArrayList<Long> a = new ArrayList<Long>();
            ArrayList<Long> b = new ArrayList<Long>();
            for(int j=0;j<m;j++){
                long num = input.nextLong();
                a.add(num);
            }
            for(int j=0;j<n;j++){
                long num = input.nextLong();
                b.add(num);
            }
            int flag=0;
            long result=0;
            for(int j=0;j<m;j++){
                if(b.contains(a.get(j))){
                    result = a.get(j);
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                System.out.println("YES");
                System.out.println("1" + " " + result);
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
