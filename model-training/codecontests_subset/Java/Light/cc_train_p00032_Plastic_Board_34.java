import java.util.*;
public class Main{
        static Scanner sc = new Scanner(System.in);
        static int rectangle, rhomboid;
        static String line;
        static String[] input = new String[3];
        public static void main(String[] args){
                while(read()){
                        slove();
                }
                System.out.println(rectangle);
                System.out.println(rhomboid);
                
        }
        static boolean read(){
                line = sc.nextLine();
                if(sc.hasNext() == false)
                        return false;
                input = line.split(",");
                return  true;
        }
        static void slove(){
                int w, h, diagonal;
                String tmp;
                tmp = input[0];
                w = Integer.parseInt(tmp);
                tmp = input[1];
                h = Integer.parseInt(tmp);
                tmp = input[2];
                diagonal = Integer.parseInt(tmp);
                
                if(w == h){
                        if(w*w + h*h != diagonal*diagonal)
                                rhomboid++;
                }else{
                        if(w*w + h*h == diagonal*diagonal)
                                rectangle++;
                }
        }
}