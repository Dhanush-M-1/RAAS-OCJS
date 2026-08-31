
import java.io.*;
import java.util.*;


public class Problem_C 
{
    
    private void run() throws IOException
    {
        // put your code here :)
        int n = nextInt();
        int m = nextInt();
        
        HashMap<Integer, Integer> weights = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            weights.put(i, nextInt());
        }
        
        int[] days = new int[m];
        for (int i = 0; i < m; i++) {
            days[i] = nextInt();
        }
        
        // find initial stack
        Stack<Integer> books = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < days.length; i++) {
            int book_today = days[i];
            if(!visited[book_today-1]){
                books.add(book_today);
                visited[book_today-1] = true;
            }
        }
        Collections.reverse(books);
        
        // calculate minimum total weight
        int total_weight = 0;
        for (int i = 0; i < days.length; i++) {
            int book_to_read = days[i];
            Stack<Integer> spare = new Stack<>();

            int temp = books.peek();
            while(temp != book_to_read){
                int current_book = books.pop();
                total_weight += weights.get(current_book);
                spare.push(current_book);
                if(books.isEmpty()){
                    System.out.println("empty");
                }
                    
                temp = books.peek();
            }
            
            int needed_book = books.pop();
            while(!spare.isEmpty()){
                books.push(spare.pop());
            }
            books.push(needed_book);
        }
        
        System.out.println(total_weight);
        
    }
    
    private int nextInt() throws IOException {
            if (input.hasMoreTokens())
                    return Integer.parseInt(input.nextToken());
            input = new StringTokenizer(in.readLine());
            return nextInt();
    
    }
    
    private void end() throws IOException {
            in.close();
            out.flush();
            out.close();
            System.exit(0);
    }
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer input;
    
    public Problem_C() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            input = new StringTokenizer("");
    }
    
    public static void main(String[] args) throws Exception {
        Problem_C sol = new Problem_C();
            sol.run();
            sol.end();
    }


}
