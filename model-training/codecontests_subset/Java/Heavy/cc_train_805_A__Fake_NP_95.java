import java.io.*;
import java.util.*;

public class Main
{    
    public static void main(String[] args) throws IOException 
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		if(l == r) System.out.println(l);
		else System.out.println(2);
    }

    static double findDistanceBetweenTwoPoints(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    static int[] countLetterFreqeuncy(String str, int[] ltrs){
        for(int i=0; i<str.length(); i++)
            ltrs[(int) (str.charAt(i) - 'a')]++;
        return ltrs;
    }
	
    static long gcd(long a, long b) { 
        if (a == 0) 
            return b;  
        return gcd(b % a, a);  
    } 
      
    static long lcm(long a, long b) { 
        return (a*b)/
        gcd(a, b); 
    } 

    // Arrays.sort(arr, new Comparator<Integer[]>() {
    //     @Override
    //             //arguments to this method represent the arrays to be sorted   
    //     public int compare(Integer[] arr1, Integer[] arr2) {
    //             //get the item ids which are at index 0 of the array
    //             Integer item1 = arr1[0];
    //             Integer item2 = arr2[0];
    //         // sort based on price
    //         return item1.compareTo(item2);
    //     }
    // });

    //String.join("", Collections.nCopies(n-1, "");

    static int binarySearch(int left, int right, int find, int[] arr){
        int mid = left + (right-left)/2;
        if(find == arr[mid]) return mid;
        else if(find < arr[mid]) return binarySearch(left,mid-1,find,arr);
        else return binarySearch(mid+1,right,find,arr);
    }

    static ArrayList<Integer> separateDigits(int num){
         int pow = 0;
         ArrayList<Integer> arr = new ArrayList<>();
         while(num != 0)
         {
             if(num % 10 != 0)
             {
                 arr.add((num % 10) * (int) Math.pow(10, pow));
             }
             num /= 10;
             pow++;
         }
         return arr;
     }

     //find pattern
//     for(int i = 0; i<n-1; i++)
//     {
//         for(int j = 0; j<m-1; j++)
//         {
//                 if(pixel[i].charAt(j)*pixel[i+1].charAt(j)*pixel[i].charAt(j+1)*pixel[i+1].charAt(j+1) == 'f'*'a'*'c'*'e')
//                     faceNum++;
//         }
//     }


// row and column checking
    // static boolean checkAllRows(String[] board)
    // {
    //     for(int i=0; i<board.length; i++)
    //     {
    //         for(int j=0; j<board.length; j++)
    //         {
    //             if(board[i].charAt(j) == 'B')
    //             {
    //                 return false;
    //             } 
    //         }
    //     }
    //     return true;
    // }

    

    class Pair implements Comparable<Pair>{
        int x;
        int y;
     
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair p)
        {
            if(p.y == y)
            return x - p.x;
            return p.y - y;
        }
    }
}




