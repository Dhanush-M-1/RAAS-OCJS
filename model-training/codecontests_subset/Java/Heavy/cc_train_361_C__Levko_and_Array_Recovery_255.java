import java.io.*;
import java.util.*;
import java.math.*;



public class Task{
    public static void main(String[] args) throws IOException{
        new Task().run();
    }
    
    StreamTokenizer in; 
    Scanner ins;
    PrintWriter out;

    int nextInt() throws IOException{
        in.nextToken();      
        return (int)in.nval;
    }
    
    long nextLong() throws IOException{
        in.nextToken();      
        return (long)in.nval;
    }
    
    double nextDouble() throws IOException{
        in.nextToken();      
        return in.nval;
    }
    
    char nextChar() throws IOException{
        in.nextToken();
        return (char)in.ttype;
    }
    
    String nextString() throws IOException{
        in.nextToken();
        return in.sval;
    }
     
    private static final String INPUT = "g.in";
    private static final int MAX_VALUE = 1000000000;
    
    class ArrayElement{
        public int add;
        public int maxVal;
        public ArrayElement(){
            add = 0;
            maxVal = MAX_VALUE;
        }
    }
    
    class OperationElement{
        public int t, l, r, k;
        public OperationElement(int t, int l, int r, int k){
            this.t = t;
            this.l = l;
            this.r = r;
            this.k = k;
        }
    }
    ArrayElement[] array;
    OperationElement[] operations;

    void run() throws IOException{        
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        ins = new Scanner(System.in);        
        out = new PrintWriter(System.out);        
        
        try{
            if(System.getProperty("xDx") != null){
                in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
                ins = new Scanner(new FileReader("input.txt"));
                out = new PrintWriter(new FileWriter("output.txt"));
            }else{
    //                in = new StreamTokenizer(new BufferedReader(new FileReader(INPUT)));
    //                ins = new Scanner(new FileReader(INPUT));
    //                out = new PrintWriter(System.out);
            }
        }catch(Exception e){
//            in = new StreamTokenizer(new BufferedReader(new FileReader(INPUT)));
//            ins = new Scanner(new FileReader(INPUT));
//            out = new PrintWriter(System.out);
        }
        int n = nextInt(), m = nextInt();
        array = new ArrayElement[n];
        for(int i = 0; i < n; i++){
            array[i] = new ArrayElement();
        }
        
        operations = new OperationElement[m];
        for(int i = 0; i < m; i++){
            operations[i] = new OperationElement(nextInt(), nextInt() - 1, nextInt() - 1, nextInt());            
            proceedOperation(operations[i]);
        }
        if(checkArray()){
            out.println("YES");            
            for(int i = 0; i < n; i++){
                out.printf("%d ", array[i].maxVal);
            }
        }else{
            out.print("NO");
        }
        out.close();
    }   
    
    void proceedOperation(OperationElement op){
        if(op.t == 1){
            for(int i = op.l; i <= op.r; i++){
                array[i].add += op.k;
            }
        }else if(op.t == 2){
            for(int i = op.l; i <= op.r; i++){
                array[i].maxVal = Math.min(array[i].maxVal, op.k - array[i].add);
            }
        }
    }
   
    boolean checkArray(){
        int tmpArray[] = new int[array.length];
        for(int i = 0; i < tmpArray.length; i++){
            tmpArray[i] = array[i].maxVal;
        }
        for(int i = 0; i < operations.length; i++){
            if(!checkOperation(operations[i], tmpArray)){
                return false;
            }
        }
        return true;
    }
    
    boolean checkOperation(OperationElement op, int[] arr){
        if(op.t == 1){
            for(int i = op.l; i <= op.r; i++){
                arr[i] += op.k;
            }
            return true;
        }else if(op.t == 2){
            int answ = -MAX_VALUE;
            for(int i = op.l; i <= op.r; i++){
                answ = Math.max(answ, arr[i]);
            }
            return answ == op.k;
        }
        return true;
    }
}