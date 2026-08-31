import sys,math
from collections import defaultdict,deque,Counter
from bisect import bisect_left,bisect_right 
import itertools
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))

def make_divisors(n):
    divisors = []
    for i in range(1, int(math.sqrt(n))+1):
        if n % i == 0:
            divisors.append(i)
            if i != n // i:
                divisors.append(n//i)

    divisors.sort()
    return divisors

def lcm(a,b):
    return a*b//math.gcd(a,b)
x = inp()
m = make_divisors(x)
res = [1,1]
for i in range(len(m)):
    for j in range(i):
        if lcm(m[i],m[j]) == x:
            print(m[i],m[j])
            quit()
print(1,1)