import java.util.Scanner;


public class Main2 {
    public static boolean result(int r1,int r2, int c1,int c2,int d1,int d2,int[][] square )
    {
       
        if(r1==square[0][0]+square[0][1] && r2==square[1][0]+square[1][1] && c1==square[0][0]+square[1][0] && c2==square[0][1]+square[1][1] && d1==square[0][0]+square[1][1] && d2==square[1][0]+square[0][1])
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner lectura = new Scanner(System.in);
        int r1,r2,c1,c2,d1,d2;
        while(lectura.hasNext())
        {
            r1 = lectura.nextInt();
            r2 = lectura.nextInt();
            c1 = lectura.nextInt();
            c2 = lectura.nextInt();
            d1 = lectura.nextInt();
            d2 = lectura.nextInt();
            int[][] square = new int[2][2];
            thip:
            for(int i=1000;i<10000;i++)
            {
                if(i%10==0) continue;
                String ho = String.valueOf(i);
                int a,b,c,d;
                a=Integer.parseInt(ho.charAt(0)+"");
                b=Integer.parseInt(ho.charAt(1)+"");
                c=Integer.parseInt(ho.charAt(2)+"");
                d=Integer.parseInt(ho.charAt(3)+"");
                
                  if (a==0 ||b==0  || c==0  || d==0 ) continue;
                  if(a==b || a==c || a==d || b==c || b==d || c==d ) continue;
        
                 square[0][0]=Integer.parseInt(ho.charAt(0)+"");
                 square[0][1]=Integer.parseInt(ho.charAt(1)+"");
                 square[1][0]=Integer.parseInt(ho.charAt(2)+"");
                 square[1][1]=Integer.parseInt(ho.charAt(3)+"");
//            System.out.println(ho);
//            for(int K=0;K<2;K++)
//            {
//                    System.out.println(square[K][0]+" "+square[K][1]);
//            }
//                System.out.println("");
            if(result(r1, r2, c1, c2, d1, d2, square))
            {
                for(int K=0;K<2;K++)
                {
                    System.out.println(square[K][0]+" "+square[K][1]);
                }
                break thip;
            }else{
                if(i==9876)
                    System.out.println("-1");
            }
            
            }
        }
    }
    
}