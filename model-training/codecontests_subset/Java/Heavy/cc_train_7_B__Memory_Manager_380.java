import java.util.Scanner;

public class MemoryManagerB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        int[] matrix = new int[m];
        String operation;
        int num;
        int operationNum = 0;
        int erasedNum = 0;
        for(int i = 0 ; i < t ; i++) {
            operation = scanner.next();
            switch (operation) {
                case "alloc":
                    num = scanner.nextInt();
                    boolean availableSpace = false;
                    int cnt = 0;
                    if(num <= m) {
                        for(int j = 0 ; j < m ; j++) {
                            if(matrix[j] == 0) {
                                cnt++;
                                if(cnt == num) {
                                    operationNum++;
                                    for(int k = 0 ; k < cnt ; k++) {
                                        matrix[j - k] = operationNum;
                                    }
                                    availableSpace = true;
                                    break;
                                }
                            } else {
                                cnt = 0;
                            }
                        }
                    }
                    if(availableSpace) 
                        System.out.println(operationNum);
                    else
                        System.out.println("NULL");
                    break;
                case "erase":
                    num = scanner.nextInt();
                    boolean found = false;
                    if(num <= operationNum && num > 0) {
                        for(int j = 0 ; j < m ; j++) {
                            if(matrix[j] == num) {
                                matrix[j] = 0;
                                found = true;
                                erasedNum++;
                            }
                        }
                    }
                    if(!found) {
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    }
                    break;
                case "defragment":
                    if(operationNum != erasedNum) {
                        int st = 0;
                        while(true) {
                            for(int j = st ; j < m ; j++) {
                                if(matrix[j] == 0) {
                                    st = j;
                                    break;
                                }
                            }
                            boolean exist = false;
                            for(int j = st ; j < m ; j++) {
                                if(matrix[j] != 0) {
                                    exist = true;
                                    matrix[st] = matrix[j];
                                    matrix[j] = 0;
                                    break;
                                }
                            }
                            if(!exist) break;
                        }
                    }
                    break;
            }
        }
    }
}