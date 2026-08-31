import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        List<Integer> t1 = new ArrayList<>();//偶数列
        List<Integer> t2 = new ArrayList<>();//奇数列
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
                t1.add(a[i]);
            }else {t2.add(a[i]);}
        }
        //倒叙排序
        Collections.sort(t1);
        Collections.sort(t2);
        Collections.reverse(t1);
        Collections.reverse(t2);

        if(t1.size()>=t2.size()){
            if(t1.size()-t2.size()<=1){
                System.out.println(0);
            }else {
                int sum =0 ;
                for(int i=t2.size()+1;i<t1.size();i++){
                    sum+=t1.get(i);
                }
                System.out.println(sum);
            }
        }
            if(t2.size()>t1.size()){
                if(t2.size()-t1.size()==1){
                    System.out.println(0);
                }else {
                    int sum =0 ;
                    for(int i=t1.size()+1;i<t2.size();i++){
                        sum+=t2.get(i);
                    }
                    System.out.println(sum);
                }
        }
    }
}