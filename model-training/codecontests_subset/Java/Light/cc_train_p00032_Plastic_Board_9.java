import java.util.*;

class Main {


    static boolean isDiamond( ArrayList<Integer> t) {
        if (t.get(0) == t.get(1))   return true;
        else    return false;
    }

    static boolean isRectangle ( ArrayList<Integer> t ) {
        if (t.get(0) * t.get(0) + t.get(1) * t.get(1) == t.get(2) * t.get(2))
            return true;
        else
            return false;
    }

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);

        int rectangle = 0;
        int diamond = 0;

        while(sc.hasNext()) {
            String [] line = sc.nextLine().split(",");
            ArrayList<Integer> triangle = new ArrayList<Integer>(3);
            for(int i = 0; i < 3; i++)  triangle.add(Integer.parseInt(line[i]));
            if (isRectangle(triangle))  rectangle += 1;
            else if (isDiamond(triangle))   diamond += 1;
        }

        System.out.println(rectangle);
        System.out.println(diamond);

    }
}