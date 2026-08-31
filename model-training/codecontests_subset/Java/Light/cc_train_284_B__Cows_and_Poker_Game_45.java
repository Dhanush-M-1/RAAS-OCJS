import java.util.*;
public class Main {
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String cp = sc.nextLine();
    int Aco = 0;
    int Ico = 0;
    int Fco = 0;
    for(int i=0; i<n; i++){
        if(cp.charAt(i) == 'A'){
            Aco ++;
        }else{
            if(cp.charAt(i) == 'I')
                Ico ++;
            else
                Fco ++;
        }
    }
    if(Ico == 0){
        System.out.println(Aco);
    }else{
        if(Ico ==1)
        System.out.println(Ico);
        else
            System.out.println("0");
    }
}

}
