import math  
  
# method to print the divisors 
def printDivisors(n) : 
    c = []
    # Note that this loop runs till square root 
    i = 1
    while i <= math.sqrt(n): 
          
        if (n % i == 0) : 
              
            # If divisors are equal, print only one 
            if (n / i == i) : 
                c.append(i) 
            else : 
                # Otherwise print both 
                c.append(i)
                c.append(n//i) 
        i = i + 1
    return c
n = int(input())
p = printDivisors(n)
c = sorted(p)
if c == [1]:
    print(1,1)
else:
    l = []
    for i in range(len(c)//2):
        if (c[i]*c[len(c)-i-1])//math.gcd(c[i],c[len(c)-i-1]) == n:
            l.append([c[len(c)-i-1],c[i]])
    l = sorted(l)
    print(l[0][0],l[0][1])