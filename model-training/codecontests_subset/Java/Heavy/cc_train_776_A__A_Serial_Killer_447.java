import java.util.Scanner;
public class SerialKiller {
    static Scanner in;
    static String initial;
    static int NbDays;
    static String[] Solution;
    static void DeleteReplace(String Dead,String New){
        int SpacePos = initial.indexOf(" ");
        String P1 = initial.substring(0,SpacePos);
        String P2 = initial.substring(SpacePos+1);
        if(P1.equals(Dead)){
            initial = New + " " + P2;
        }else{
            initial = P1 + " " + New; 
        }
    }
    static void Solve(String S){
        Scanner sc = new Scanner (S);
        String Dead = sc.next(), New = sc.next();
        DeleteReplace(Dead,New);
    }
    public static void main(String args[]){
        in = new Scanner (System.in);
        initial = in.next()+" "+in.next();
        NbDays = in.nextInt();
        int i = 0;
        String DAYi;
        Solution = new String[NbDays+1];
        Solution[i] = initial;
    while (i < NbDays){
        DAYi = in.next()+" "+in.next();
        Solve(DAYi);
        Solution[i+1]=initial;
        i++;
    }
    for(String S:Solution)System.out.println(S);
    }
}
