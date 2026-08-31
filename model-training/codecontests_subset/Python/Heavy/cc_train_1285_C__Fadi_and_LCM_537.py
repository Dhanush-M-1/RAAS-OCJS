import math
def printDivisors(n) : 
    i = 1
    factors = []
    while i <= math.sqrt(n): 
        if (n % i == 0) : 
            if (n // i == i) : 
                factors.append(i)
            else : 
                factors.append(n//i)
                factors.append(i)
        i = i + 1
    return factors

def gcd(a, b):  
    if a == 0 : 
        return b  
      
    return gcd(b%a, a) 
        
n = int(input())
if n == 1:
    print(1,1)
else:
    factors = printDivisors(n)
    i = len(factors)-1
    while i >= 0:
        if n//factors[i] == factors[i]:
            i -= 1
        else:
            if gcd(factors[i],factors[i-1]) == 1:
                break
            else:
                i -= 2

    print(factors[i],n//factors[i])