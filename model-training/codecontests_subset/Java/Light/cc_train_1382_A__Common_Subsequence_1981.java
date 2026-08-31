import java.util.*;
public class com{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        List<Integer> l=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        int t=sc.nextInt();
        while(t-- > 0){
            l.clear();
            l1.clear();
            int n=sc.nextInt();
            int m=sc.nextInt();
            int x=n;
            int y=m;
            int c=0;
            while(x-- > 0){
                l.add(sc.nextInt());
            }
            while(y-- > 0){
                l1.add(sc.nextInt());
            }
            if(m >= n){
                for(int i=0; i<l.size(); i++){
                    if(l1.contains(l.get(i))){
                        System.out.println("YES");
                        System.out.println("1 "+ l.get(i));
                        break;
                    }else{
                        c++;
                    }
                }
            }else{
              for(int i=0; i<l1.size(); i++) {
                    if(l.contains(l1.get(i))){
                        System.out.println("YES");
                        System.out.println("1 "+ l1.get(i));
                        break;
                    }else{
                        c++;
                    }
                } 
            }
            if(c == l.size() || c == l1.size()){
                System.out.println("NO");
            }
        }
    }
}