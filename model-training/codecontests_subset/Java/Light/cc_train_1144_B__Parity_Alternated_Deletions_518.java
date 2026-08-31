import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> oddlist = new ArrayList<Integer>();
        ArrayList<Integer> evenlist = new ArrayList<Integer>();
        for( int i = 0 ; i < n ; i++ ){
            int nex = in.nextInt();
            if( nex % 2 == 0 ) evenlist.add(nex);
            else oddlist.add(nex);
        }
        Collections.sort(oddlist);
        Collections.sort(evenlist);
        int total = 0;
        if( oddlist.size() > evenlist.size()+1 ){
            for( int i = 0 ; i < oddlist.size()-evenlist.size()-1 ; i++ ){
                total += oddlist.get(i);
            }
        }
        if( evenlist.size() > oddlist.size()+1 ){
            for( int i = 0 ; i < evenlist.size()-oddlist.size()-1 ; i++ ){
                total += evenlist.get(i);
            }
        }
        System.out.println(total);
    }
}
