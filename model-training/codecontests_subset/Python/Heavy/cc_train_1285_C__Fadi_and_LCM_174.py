from sys import maxsize, stdout, stdin,stderr
mod = int(1e9 + 7)
def I(): return int(stdin.readline())
def lint(): return [int(x) for x in stdin.readline().split()]
def S(): return input().strip()
def grid(r, c): return [lint() for i in range(r)]
from collections import defaultdict, Counter
import math
from itertools import groupby
def gcd(a,b): 
    while b:
        a %= b
        tmp = a
        a = b
        b = tmp
    
    return a

def lcm(a,b): 
    return a / gcd(a, b) * b

def check_prime(n):
    for i in range(2,n):
        if n%i==0:
            return 0
    return 1
 
    
n = I()
ans=None
i=1
while i**2<=n:
    if n%i==0 and lcm(i, n//i)==n:
        ans=i
    i+=1
print(ans, n//ans)
