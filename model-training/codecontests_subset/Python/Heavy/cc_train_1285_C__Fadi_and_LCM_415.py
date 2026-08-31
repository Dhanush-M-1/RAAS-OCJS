import math
def lcm(x, y):

    return x * y // math.gcd(x, y)
def isPrime(n) :
    if (n <= 1) :
        return False
    if (n <= 3) :
        return True
    if (n % 2 == 0 or n % 3 == 0) :
        return False
    i = 5
    while(i * i <= n) :
        if (n % i == 0 or n % (i + 2) == 0) :
            return False
        i = i + 6
    return True
from functools import reduce
n=int(input())
if(isPrime(n)):
    print(1,n)
else:


    s=list(reduce(list.__add__,([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))

    t=len(s)
    s.sort()


    for i in range(int(t/2)):
        if(lcm(s[int(t/2)-i-1],s[int(t/2)+i])==n):
            print(s[int(t/2)-i-1],s[int(t/2)+i])
            break