import java.util.Scanner;
import java.util.ArrayList;

class Main{
    public static void main(String[] args){
        ArrayList<String> tlist=new ArrayList<String>();
        for(int i=1;i<=13;i++){
            tlist.add("S "+Integer.toString(i));
        }
        for(int i=1;i<=13;i++){
            tlist.add("H "+Integer.toString(i));
        }
        for(int i=1;i<=13;i++){
            tlist.add("C "+Integer.toString(i));
        }
        for(int i=1;i<=13;i++){
            tlist.add("D "+Integer.toString(i));
        }
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        ArrayList<String> a=new ArrayList<String>();
        String s;
        for(int i=0;i<=num;i++){
            s=sc.nextLine();
            a.add(s);
            tlist.remove(a.get(i));
        }
        for(String str:tlist){
            System.out.println(str);
        }
    }
}
