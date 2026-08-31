from sys import stdin, stdout
X = int(input())
import math 
  
# A function to print all prime factors of  
# a given number n 
def primeFactors(n): 
    ans = []
    # Print the number of two's that divide n 
    temp = 1
    while n % 2 == 0: 
        temp*=2
        n = n / 2
    if temp!=1: ans.append(int(temp))
    # n must be odd at this point 
    # so a skip of 2 ( i = i + 2) can be used 
    for i in range(3,int(math.sqrt(n))+1,2): 
          
        # while i divides n , print i ad divide n 
        temp = 1
        while n % i== 0: 
            temp *= i
            n = n / i 

        if temp!=1:
            ans.append(int(temp))
    # Condition if n is a prime 
    # number greater than 2 
    if n > 2: 
        ans.append(int(n))

    return ans

pfactors = primeFactors(X)
pfactors.sort()

from itertools import *
from operator import mul
from functools import reduce

diff = 10**12
mina, minb = None, None
for pattern in product([True,False],repeat=len(pfactors)):
    a = reduce(mul, [x[1] for x in zip(pattern,pfactors) if x[0]], 1)
    b = reduce(mul, [x[1] for x in zip(pattern,pfactors) if not x[0]], 1)

    if abs(a-b) < diff:
        diff = abs(a-b)
        mina, minb = a, b

print(mina, minb)