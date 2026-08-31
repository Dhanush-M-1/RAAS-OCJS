import java.util.*;

public class MisterBAndBookReading {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        int c = in.nextInt();
        int v0 = in.nextInt();
        int v1 = in.nextInt();
        int a = in.nextInt();
        int l = in.nextInt();
        int days = 0;
        int pagesRead = 0;
        while(pagesRead < c){
            if(days == 0){
                pagesRead += v0;
            }else{
                pagesRead -= l;
                pagesRead += v0;
            }
            if(v0 < v1){
                v0 += a;
                if(v0 > v1){
                    v0 = v1;
                }
            }
            days++;
        }
        System.out.println(days);
    }

}
