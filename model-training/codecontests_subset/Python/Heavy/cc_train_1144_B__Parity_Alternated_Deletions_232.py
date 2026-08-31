def MinimizeleftOverSum(a, n) : 
      
    v1, v2 = [], [];  
    for i in range(n) :  
          
        if (a[i] % 2) : 
            v1.append(a[i]);  
        else : 
            v2.append(a[i]);  
      
    # If more odd elements  
    if (len(v1) > len(v2)) :  
  
        # Sort the elements  
        v1.sort();  
        v2.sort();  
  
        # Left-over elements  
        x = len(v1) - len(v2) - 1;  
  
        sum = 0;  
        i = 0;  
  
        # Find the sum of leftover elements  
        while (i < x) :  
            sum += v1[i]; 
            i += 1
  
        # Return the sum  
        return sum;  
      
    # If more even elements  
    elif (len(v2) > len(v1)) : 
  
        # Sort the elements  
        v1.sort();  
        v2.sort();  
  
        # Left-over elements  
        x = len(v2) - len(v1) - 1;  
  
        sum = 0;  
        i = 0;  
  
        # Find the sum of leftover elements  
        while (i < x) : 
            sum += v2[i]; 
            i += 1
          
        # Return the sum  
        return sum;  
      
    # If same elements  
    else : 
        return 0;  
  
# Driver code  
if __name__ == "__main__" :  
  
    n = int(input())
    a = list(map(int,input().split()))
    n = len(a);  
      
    print(MinimizeleftOverSum(a, n));  