import java.util.*;

class Main{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                int rectangles = 0;
                int lozenges = 0;
                while(sc.hasNext()){
                        String[] s = sc.nextLine().split(",");
                        int[] a = new int[3];
                        for(int i = 0; i < 3; i++){
                                a[i] = Integer.parseInt(s[i]);
                        }   
                        if(a[0]*a[0]+a[1]*a[1] == a[2]*a[2]){
                                rectangles++;
                        }   
                        if(a[0] == a[1]){
                                lozenges++;
                        }   
                }   
                System.out.println(rectangles+"\n"+lozenges);
        }   
}