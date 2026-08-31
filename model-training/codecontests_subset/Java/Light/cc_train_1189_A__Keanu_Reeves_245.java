import java.util.*;

public class TestClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cut cut = new Cut(sc.nextInt(), sc.next());
        String[] answer = cut.cut();
        System.out.println(answer.length);
        for(String s : answer) {
            System.out.print(s + " ");
        }
    }

}

class Cut {

    private int length;
    private String string;

    public Cut(int length, String string) {
        this.length = length;
        this.string = string;
    }

    public String[] cut() {

        if(length == 1) return new String[]{string};

        char[] p = string.toCharArray();
        char[] _p = new char[length - 1];

        int unitCounter = 0;
        int zeroCounter = 0;

        for(int i = 0; i < length; i++) {
            if(p[i] == '1') unitCounter++;
            else zeroCounter++;
            if(i > 0) _p[i - 1] = p[i];
        }

        if(unitCounter != zeroCounter) return new String[]{string};

        String[] ret = new String[2];
        ret[0] = String.valueOf(p[0]);
        ret[1] = String.valueOf(_p);

        return ret;
    }

}