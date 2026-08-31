import java.util.Scanner;

public class Pixel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long i,j,k,n,a,b,c,big,middle,small,sum;
        boolean is;
        while (input.hasNext()){
            a = input.nextLong(); b = input.nextLong(); c = input.nextLong(); sum = 0; is = false;

            big = (a>=b) ? ((a>=c)? a :c) : ((b>=c) ? b : c);
            small = (a>=b) ? ((b>=c) ? c : b) : ((a>=c) ? c : a);
            middle = a>b ? (c>a ? a :(b>c)? b:c) : (c>b ? b : a>c? a : c);

           // System.out.println(big+ " " + middle + " " + small);
            for (i=0; i<big; i++){
                if (big == middle || big == small || middle == small) break;
                if ((middle - small ) % 2 == 0){
                   // big--;middle--;small++;
                    j = (middle - small);
                   // sum += (j/2);
                    sum += (small + j);
                    is = true;
                    break;
                }
                else break;
            }
            if (!is) {
                if (big == middle) sum += big;
                else if (big == small) sum += big;
                else if (small == middle) sum += small;
                else sum += big; System.out.println(sum);
            }
            else
            System.out.println(sum);
        }
    }
}
