import java.io.*;
import java.util.*;
public class lat{
    public static String most(String gram,int panjang){
        String banyak = "";
        HashMap<String,Integer> simpan = new HashMap<String,Integer>();
        for (int i = 0;i<panjang-1;i++){
            if (simpan.containsKey(gram.substring(i,i+2))){
                Integer b = simpan.get(gram.substring(i, i+2));
                b += 1;
                simpan.put(gram.substring(i, i+2),b);
            }
            else{
                simpan.put(gram.substring(i, i+2),1);
            }
        }
        Integer max = -1;
        for (String i:simpan.keySet()){
            if (max < simpan.get(i)){
                max = simpan.get(i);
                banyak = i;
            }
        }
        return banyak;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        String terbanyak = most(a,n);
        System.out.println(terbanyak);

    }

}
