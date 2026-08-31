import java.util.*;
public class A_Games{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCase=1; int ans=0;
        //testCase=Integer.parseInt(sc.nextLine());
        while(testCase-->0){
            int n=sc.nextInt();
            int homeCount[]=new int[100];
            int awayCount[]=new int[100];
            while(n-->0){
                int home,away;
                home=sc.nextInt();
                away=sc.nextInt();
                homeCount[home-1]++;
                awayCount[away-1]++;
            }
            for(int i=0;i<100;i++){
                if(homeCount[i]!=0){
                    ans+=homeCount[i]*awayCount[i];
                }
            }
        }
        System.out.println(ans);
    }
}