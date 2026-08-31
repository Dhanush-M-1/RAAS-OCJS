import java.util.*;
import java.lang.*;
import java.io.*;

public class B676
{  
    public static boolean pathExists(int arr[][], int x){
        int n = arr.length;
        if (arr[1][0] == x || arr[0][1] == x){
            if (arr[n - 1][n - 2] == x || arr[n - 2][n - 1] == x){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static void help(int arr[][], int x, int y){
        int n = arr.length;
        int a = arr[0][1];
        int b = arr[1][0];
        int c = arr[n - 1][n - 2];
        int d = arr[n - 2][n - 1];

        if (a == x && b == x){
            if (c == x && d == x){
                System.out.println(2);
                System.out.println((n) + " " + (n - 1));
                System.out.println((n - 1) + " " + (n));
                return;    
            }
            else if (c == x){
                System.out.println(1);
                System.out.println((n) + " " + (n - 1));
                return;
            }
            else if (d == x){
                System.out.println(1);
                System.out.println((n - 1) + " " + (n));
                return;
            }
        }
        else if (a == x && b == y){
            if (c==x && d==x){
                System.out.println(1);
                System.out.println(1 + " " + 2);
                return;
            }
            else if (c == x){
                System.out.println(2);
                System.out.println(1 + " " + 2);
                System.out.println((n - 1) + " " + (n));
                return;
            }
            else if (d == x){
                System.out.println(2);
                System.out.println(1 + " " + 2);
                System.out.println((n) + " " + (n - 1));
                return;
            }
        }
        else if (a == y && b == x){
            if (c == x && d == x){
                System.out.println(1);
                System.out.println(2 + " " + 1);
                return;
            }
            else if (c == x){
                System.out.println(2);
                System.out.println(2 + " " + 1);
                System.out.println((n - 1) + " " + (n));
                return;
            }
            else if (d == x){
                System.out.println(2);
                System.out.println(2 +" " + 1);
                System.out.println((n) + " " + (n - 1));
                return;
            }
        }
    }

    public static void func(int arr[][]){
        int n = arr.length;

        //for 0 //handle case of row matrix and col matrix
        boolean first = pathExists(arr, 0);
        boolean second = pathExists(arr, 1);
        
        if (first && second){
            if (arr[0][1] == 0){
                if (arr[n - 1][n - 2] == 1){
                    System.out.println(2);
                    System.out.println(1 + " " + 2);
                    System.out.println((n) + " " + (n - 1));
                    return;
                }
                else if (arr[n -2][n - 1] == 1){
                    System.out.println(2);
                    System.out.println(1 + " " + 2);
                    System.out.println((n - 1) + " " + (n));
                    return;
                }
            }
            else if (arr[1][0] == 0){
                if (arr[n - 1][n - 2] == 1){
                    System.out.println(2);
                    System.out.println(2 + " " + 1);
                    System.out.println((n) + " " + (n - 1));
                    return;
                }
                else if (arr[n -2][n - 1] == 1){
                    System.out.println(2);
                    System.out.println(2 + " " + 1);
                    System.out.println((n - 1) + " " + (n));
                    return;
                }
            }
        }
        else if (first){
            help(arr, 0, 1);
            return;
        }else if (second){
            help(arr, 1, 0);
            return;
        }
        else{
            System.out.println(0);
            return;
        }
    }

	public static void main (String[] args) throws java.lang.Exception{
        //Scanner s = new Scanner(System.in);
        FastReader s = new FastReader();
        int t = s.nextInt();
        while (t-- != 0){
            int n = s.nextInt();
            int arr[][] = new int[n][n];
            for (int i = 0; i < n; i++){
                String str = s.nextLine();
                for (int j = 0; j < n; j++){
                    char ch = str.charAt(j);
                    if (ch == 'S'){
                        arr[i][j] = 2;
                    }
                    else if (ch == 'F'){
                        arr[i][j] = 3;
                    }
                    else{
                        arr[i][j] = Character.getNumericValue(ch);
                    }
                }
            }
            func(arr);
        }

	}

////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////-----------FAST READER------------/////////////////////////
    static class FastReader { 
            BufferedReader br; 
            StringTokenizer st; 
    
            public FastReader() 
            { 
                br = new BufferedReader(new
                        InputStreamReader(System.in)); 
            } 
    
            String next() 
            { 
                while (st == null || !st.hasMoreElements()) 
                { 
                    try
                    { 
                        st = new StringTokenizer(br.readLine()); 
                    } 
                    catch (IOException  e) 
                    { 
                        e.printStackTrace(); 
                    } 
                } 
                return st.nextToken(); 
            } 
    
            int nextInt() 
            { 
                return Integer.parseInt(next()); 
            } 
    
            long nextLong() 
            { 
                return Long.parseLong(next()); 
            } 
    
            double nextDouble() 
            { 
                return Double.parseDouble(next()); 
            } 
    
            String nextLine() 
            { 
                String str = ""; 
                try
                { 
                    str = br.readLine(); 
                } 
                catch (IOException e) 
                { 
                    e.printStackTrace(); 
                } 
                return str; 
            } 
    }

}
