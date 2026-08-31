import java.util.*;

public class CommonSubSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();

        while(t>0){
            int m,n;
            m=in.nextInt();
            n=in.nextInt();

            Set<Integer> set=new HashSet<>();
            for(int i=0;i<m;i++){
                int x=in.nextInt();
                set.add(x);
            }
            boolean isComm=false;
            int num=0;
            for (int j=0; j<n;j++){
                int x=in.nextInt();
                if(set.contains(x)){
                    isComm=true;
                    num=x;

                }
            }
            if (isComm){
                System.out.println("YES");
                System.out.println("1 "+num);
            }else{
                System.out.println("NO");
            }

            t--;
        }
    }
}
