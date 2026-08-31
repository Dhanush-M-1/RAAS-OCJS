mod = 10**9 + 7
import math
from collections import Counter
from itertools import combinations


def ain():
    return map(int, input().split())
def fain():
    return map(float, input().split())

def primeFactors(n): 
    if n == 1:
        return [1]
    l = []
    # Print the number of two's that divide n 
    while n % 2 == 0: 
        #print 2,
        l.append(2) 
        n = n / 2
          
    # n must be odd at this point 
    # so a skip of 2 ( i = i + 2) can be used 
    for i in range(3,int(math.sqrt(n))+1,2): 
          
        # while i divides n , print i ad divide n 
        while n % i== 0: 
            l.append(int(i)) 
            n = n / i 
              
    # Condition if n is a prime 
    # number greater than 2 
    if n > 2: 
        l.append(int(n)) 
    return l
x = int(input())
a = 1; b = x
for i in range(1, int(math.sqrt(x)) + 1):
    if x%i == 0 and math.gcd(i,x//i) == 1:
        a = i
        b = x//i
print(a,b)