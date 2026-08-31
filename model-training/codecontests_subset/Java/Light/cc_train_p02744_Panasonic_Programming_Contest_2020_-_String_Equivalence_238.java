import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder strb = new StringBuilder();

        ArrayDeque<Word> dfs = new ArrayDeque<>();
        dfs.addFirst(new Word(n));
        while(!dfs.isEmpty()){
            Word tmp = dfs.removeLast();
            if(tmp.length < n){
                for(int i = 0 ; i <= tmp.useMax ; i++){
                    dfs.addFirst(tmp.append((char)('a'+i)));
                }
            }else{
                strb.append(tmp.data);
                strb.append("\n");
            }
        }
        System.out.println(strb.toString());
    }
}

class Word{
    char[] data;
    int length;
    int useMax;

    Word(int n){
        data = new char[n];
        length = 0;
        useMax = 0;
    }

    Word(Word tar){
        this.data = new char[tar.data.length];
        for(int i = 0; i < tar.length ; i++){
            this.data[i] = tar.data[i];
        }
        this.length = tar.length;
        this.useMax = tar.useMax;
    }

    Word append(char c){
        Word tmp = new Word(this);
        tmp.data[tmp.length] = c;
        tmp.length++;
        if(c >= (char)('a'+tmp.useMax)){
            tmp.useMax++;
        }
        return tmp;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}