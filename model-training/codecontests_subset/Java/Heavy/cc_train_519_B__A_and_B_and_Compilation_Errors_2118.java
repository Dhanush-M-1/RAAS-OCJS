import java.util.*;

public class CompilationErrors {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Hashtable<Integer, Integer> errorCodeFreqs = new Hashtable<Integer, Integer>(n);
    Hashtable<Integer, Integer> clone1 = new Hashtable<Integer, Integer>();
    Hashtable<Integer, Integer> clone2 = new Hashtable<Integer, Integer>();
    int firstErrorCodeSolved = 0;
    int secondErrorCodeSolved = 0;

// 1st line
    // create initial hash table
    for (int i = 0; i < n; i++) {
      int errorCode = sc.nextInt();
      int freq = errorCodeFreqs.containsKey(errorCode) ? errorCodeFreqs.get(errorCode) + 1 : 1;
      errorCodeFreqs.put(errorCode, freq);
    }

// 2nd line
    // clone hash table
    clone1 = (Hashtable<Integer, Integer>)errorCodeFreqs.clone();

    // decrement values in clone1 for every value in next line
    for (int i = 0; i < n - 1; i++) {
      int errorCode = sc.nextInt();
      clone1.put(errorCode, clone1.get(errorCode) - 1);
    }

    Enumeration<Integer> keys1 = clone1.keys();

    // find key where value is 1
    while (keys1.hasMoreElements()) {
      int key = keys1.nextElement();
      if (clone1.get(key) == 1) {
        firstErrorCodeSolved = key;
        break;
      }
    }

// ---- 3rd line
    // clone hash table again
    clone2 = (Hashtable<Integer, Integer>)errorCodeFreqs.clone();

    // decrement firstErrorCodeSolved
    clone2.put(firstErrorCodeSolved, clone2.get(firstErrorCodeSolved) - 1);

    // decrement values in clone2 for every value in next line
    for (int i = 0; i < n - 2; i++) {
      int errorCode = sc.nextInt();
      clone2.put(errorCode, clone2.get(errorCode) - 1);
    }

    Enumeration<Integer> keys2 = clone2.keys();

    // find key where value is 1
    while (keys2.hasMoreElements()) {
      int key = keys2.nextElement();
      if (clone2.get(key) == 1) {
        secondErrorCodeSolved = key;
        break;
      }
    }

    System.out.println(firstErrorCodeSolved);
    System.out.println(secondErrorCodeSolved);

  }
}
