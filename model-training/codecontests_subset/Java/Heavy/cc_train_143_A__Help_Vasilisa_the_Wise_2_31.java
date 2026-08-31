import java.util.*;
public class Div2A143 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        sc.nextLine();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        sc.nextLine();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();      
        double x = (r1 + c1 - d2)/2.0;
        double y = (d2 - c1 + r1)/2.0;
        double w = (c1 -r1 + d2)/2.0;
        double z = (2*r2 - c1 +r1 - d2)/2.0;
        if(x<= 0 || y<= 0 || w<= 0 || z<= 0 || x==y || x==z  || x==w|| y== w || y== z||  w==z || x>9 || y>9 || w>9 || z>9 ){
            System.out.println(-1);
        }
        else if(Math.floor(x) == x && Math.floor(y) == y && Math.floor(w) == w && Math.floor(z) == z && c2 == y+z && d1 == x+z ){
            System.out.println((int)x + " " + (int)y);
            System.out.println((int)w + " " + (int)z);
        }
        else {
            System.out.println(-1);
        }
        
        sc.close();
  
     
     }
}
