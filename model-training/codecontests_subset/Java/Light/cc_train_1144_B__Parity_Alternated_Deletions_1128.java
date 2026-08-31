
import java.util.*;

public class _1144B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        ArrayList<Integer> ar_ji=new ArrayList<>();
        ArrayList<Integer> ar_ou=new ArrayList<>();

        for (int i=0;i<n;i++){
            int number=sc.nextInt();
            if (number%2!=0){
                ar_ji.add(number);
            }else {
                ar_ou.add(number);
            }
        }

        if (ar_ji.size()-ar_ou.size()==1||ar_ou.size()-ar_ji.size()==1||ar_ji.size()==ar_ou.size()){
            System.out.println(0);
        }else {
            Collections.sort(ar_ji);
            Collections.sort(ar_ou);

            if (ar_ji.size()>ar_ou.size()){
                int x=ar_ji.size()-ar_ou.size();
                int sum=0;
                for (int i=0;i<x-1;i++){
                    sum+=ar_ji.get(i);

                }
                System.out.println(sum);
            }else{
                int x=ar_ou.size()-ar_ji.size();
                int sum=0;
                for (int i=0;i<x-1;i++){
                    sum+=ar_ou.get(i);
                }
                System.out.println(sum);
            }

        }




    }
}
