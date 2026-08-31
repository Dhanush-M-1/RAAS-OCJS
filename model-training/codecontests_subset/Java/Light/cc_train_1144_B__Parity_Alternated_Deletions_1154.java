import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        int sE=0;
        int sO=0;
        ArrayList<Integer>even = new ArrayList<>();
        ArrayList<Integer>odd = new ArrayList<>();
        for(int i=0;i<n;i++){
           int m = sc.nextInt();
            if(m%2==0){
                even.add(m);
                minEven = Math.min(minEven,m);
                sE+=m;
            }else{
                odd.add(m);
                minOdd = Math.min(minOdd,m);
                sO+=m;
            }
        }
        int sum=sO+sE;
        int res=0;
        if(even.size()>odd.size()){
            Collections.sort(even);
             for(int i=0;i<even.size()-odd.size()-1;i++){
                 res+=even.get(i);
             }
        }else{
            Collections.sort(odd);
            for(int i=0;i<odd.size()-even.size()-1;i++){
                res+=odd.get(i);
            }
        }

        System.out.println(res);
       // System.out.println(even+" "+sE+" "+minEven);
        //System.out.println(odd+" "+sO+" "+minOdd);


    }
}