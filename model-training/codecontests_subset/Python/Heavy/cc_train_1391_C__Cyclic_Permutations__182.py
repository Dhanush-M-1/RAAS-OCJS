def power(x, y, p) : 
    res = 1     # Initialize result 
  
    # Update x if it is more 
    # than or equal to p 
    x = x % p  
      
    if (x == 0) : 
        return 0
  
    while (y > 0) : 
          
        # If y is odd, multiply 
        # x with result 
        if ((y & 1) == 1) : 
            res = (res * x) % p 
  
        # y must be even now 
        y = y >> 1      # y = y/2 
        x = (x * x) % p 
          
    return res
N = int(input())
Mod = 10**9 + 7
def function(X):
    A = 1
    for i in range(X,1,-1):
        A*=i
        A%=Mod
    return A
Rem = power(2,N-1,Mod)
X = function(N)
print((X-Rem)%Mod)