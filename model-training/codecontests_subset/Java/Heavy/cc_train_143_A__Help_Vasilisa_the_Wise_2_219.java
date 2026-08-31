import java.util.Scanner;

public class helpVasilisa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r1 = input.nextInt();
        int r2 = input.nextInt();
        int c1 = input.nextInt();
        int c2 = input.nextInt();
        int d1 = input.nextInt();
        int d2 = input.nextInt();
        int rlc, ruc, luc, llc;
        ruc = (r1 - d1 + c2)/2;
        rlc=c2-ruc;
        luc=r1-ruc;
        llc=d2-ruc;
        if(ruc==rlc||ruc==llc||luc==ruc||llc==rlc||llc==luc||rlc==luc||ruc==0||rlc==0||llc==0||luc==0){
            System.out.println(-1);
        }
        else if((ruc+luc)!=r1||(ruc+rlc)!=c2||(llc+rlc)!=r2||(luc+rlc)!=d1||(ruc+llc)!=d2||(luc+llc)!=c1){
            System.out.println(-1);
        }
        else if(rlc==10||ruc==10||llc==10||luc==10){
            System.out.println(-1);
        }
          else {
            System.out.println(luc + " " + ruc);
            System.out.println(llc + " " + rlc);
        }

    }
}