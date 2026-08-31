import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s;
        String[] a;
        int[] b=new int[3];
        int ch=0,hi=0;
        while(sc.hasNextLine()){
            s=sc.nextLine();
            a=s.split(",");
            for(int i=0;i<3;i++){
                b[i]=Integer.parseInt(a[i]);
            }
            if(b[0]*b[0]+b[1]*b[1]-b[2]*b[2]==0){
                ch++;
            }else if(b[0]==b[1]){
                hi++;
            }
        }
        System.out.println(ch);
        System.out.println(hi);
    }
}