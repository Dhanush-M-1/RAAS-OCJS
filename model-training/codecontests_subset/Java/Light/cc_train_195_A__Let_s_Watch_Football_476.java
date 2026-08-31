import java.util.Scanner;

public class Let {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ndata = scan.nextInt();
        int candown= scan.nextInt();
        int size= scan.nextInt();
        int f;
        int result=(ndata*size)- (candown*size);
        if((result%candown)!=0)
            f=(result/candown)+1;
        else
            f=result/candown;
        System.out.println(f);
            
    }

}