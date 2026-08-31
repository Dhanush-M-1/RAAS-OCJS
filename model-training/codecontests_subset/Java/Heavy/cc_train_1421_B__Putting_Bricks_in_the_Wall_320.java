import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

 
public final class Code {

	
	public static void main(String[] args) throws Exception{
	   	Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int i,j,k;
            int a=-1,b=-1,c=-1,d=-1;
            for(i = 0; i < n; i++) {
                String s = scanner.nextLine();
               // System.out.println("yooo  " + s);
                if(i == 0)
                    {
                        a = Integer.valueOf(s.charAt(1) - 48);
                    }
                if(i == 1)
                    {
                        b = Integer.valueOf(s.charAt(0) - 48);
                    }
                if(i == n-2)
                    {
                        c = Integer.valueOf(s.charAt(n-1) - 48);
                    }
                if(i == n-1)
                    {
                        d = Integer.valueOf(s.charAt(n-2) - 48);
                    }
            }
            int tl = a+b;
            int br = c+d;
        //    System.out.println("yooo  " + (tl-br) + " " + tl + " " + br);
            if(tl != 1 && br != 1 && tl == br) {
                print(2, 1,2,2,1);
            } else if(( tl - br == 2) || (br - tl == 2)) {
                print(0,0,0,0,0);
            } else if(((tl - br == 1) || (tl - br == -1)) && (tl ==0 || br == 0)) {
                if(tl == 1) {
                    if(a==1)
                        print(1,2,1,0,0);
                    else print(1,1,2,0,0);
                }
                else {
                    if(c==1)
                        print(1,n,n-1,0,0);
                    else print(1,n-1,n,0,0);
                }
            } else if(((tl - br == 1) || (tl - br == -1)) && (tl ==2 || br == 2)) {
                if(tl == 1) {
                    if(a==1)
                        print(1,1,2,0,0);
                    else print(1,2,1,0,0);
                }
                else {
                    if(c==1)
                        print(1,n-1,n,0,0);
                    else print(1,n,n-1,0,0);
                }
            } else {
                int x=-1,y=-1,z=-1,w=-1;
                if(a==0) {
                    x=1;y=2;
                } else if(b==0) {
                    x=2;y=1;
                }

                if(c==1) {
                    z=n-1;w=n;
                } else if(d==1) {
                    z=n;w=n-1;
                }
                print(2,x,y,z,w);
            }

            
        }
	}

    private static void print(int c1, int a, int b, int c, int d) {
        System.out.println(c1);
        if(c1>0)
            System.out.println(a + " " + b);
        if(c1 > 1)
            System.out.println(c + " " + d);
    }
	
}
