import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B7 {
	private static class Node {
        int identifier;
        int value;
        Node next;
 
        public Node(int identifier, int value) {
            this.identifier = identifier;
            this.value = value;
        }
        public String toString() {
            return identifier + " " + value;
        }
    }
    private static void swap(int[] ar, int a, int b) {
        int tmp = ar[a];
        ar[a] = ar[b];
        ar[b] = tmp;
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);//number of commands
        int total = Integer.parseInt(nm[1]);//total memory space
        Node head = new Node(-1, -1);
        int globalCounter = 1;//counting succesful commands
        Node freeList = new Node(-1, total);
 
        int[] ar = new int[total];
        for (int j = 0; j < n; j++) {
            String command = br.readLine();
   //if the command is "defragment"
            if (command.equals("defragment")) {
                int curIndex = 0;
                int zeroIndex = 0;
  //swapping closer to the beginning the occupied memmory              
                for (; curIndex < ar.length; ) {
                    if (ar[curIndex] != 0) {
                        swap(ar, curIndex, zeroIndex);
                        curIndex++;
                        zeroIndex++;
                    } else {
                        curIndex++;
                    }
                }
             //if the next command is "alloc"
            } else if (command.contains("alloc")) {
            //getting the size of allocated space "allocCount"
                Integer allocCount = Integer.parseInt(command.split(" ")[1]);//argument of alloc
                int index = -1;
                int count = 0;//used to compare the fitting size and the actual size needed to alloc
                for (int i = 0; i < ar.length; i++) {
      //if there is free space,argumment is added   	
                    if (ar[i] == 0) {
                        if (index == -1)
                            index = i;
                        count++;
 //if there is allocated enough memory, then the process interrupts        
                        if (count == allocCount) {
                            break;
                        }
//else if the segment isn'tt empty,starting count from 0
                    } else {
                        index = -1;
                        count = 0;
                    }
                }
//if the amount of allocated memory is too big compared to free space or doesn't fit,the NULL is displayed
                if (index == -1 || count < allocCount) {
                    System.out.println("NULL");
                    continue;
                }
//else is printed the count of current successful command                
                System.out.println(globalCounter);
//allocating memory into free space, beginning from the first empty space in array                
                for (int i = index; i < index + allocCount; i++) {
                    ar[i] = globalCounter;
                }
                globalCounter++;
            } else {
 //if the command is erase           	
                Integer index = Integer.parseInt(command.split(" ")[1]);
 //if the erase argument is a negative number,when "ILLEGAL_ERASE_ARGUMENT" is displayed               
                if (index <= 0) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    continue;
                }
                boolean found = false;
//if such argument is found in the memory space , then the erase is possible          
                for (int i = 0; i < ar.length; i++) {
                    if (ar[i] == index) {
                        found = true;
                        break;
                    }
                }
//if there is no such argument in the memory space array,when the error message is displayed                
                if (!found) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    continue;
                }
 //the proper process of erase, if in memory space array is found such argument,it is erased and replaced as 0 in array               
                for (int i = 0; i < ar.length; i++) {
                    if (ar[i] == index) {
                        ar[i] = 0;
                    }
                }
            }
        }
        br.close();
    }
 

 
    
}
