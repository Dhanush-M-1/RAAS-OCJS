import java.util.*;

public class Main {
    
    public static int subsequence(int[] a , int[] b){
        int pair= -1;
        HashSet<Integer> setA= new HashSet<>();
        for(int i: a){
            setA.add(i);
        }
        for(int i: b){
            if(setA.contains(i)){
                pair= i;
                break;
            }
        }
        return pair;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int n= sc.nextInt();
            int m= sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int j=0; j<a.length; j++){
                int ele= sc.nextInt();
                a[j]= ele;
            }
            for(int j=0; j<b.length; j++){
                int ele= sc.nextInt();
                b[j]= ele;
            }
            int answer = subsequence(a, b);
            if(answer==-1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                System.out.print(1+" ");
                System.out.println(answer);
            }
        }
    }
}