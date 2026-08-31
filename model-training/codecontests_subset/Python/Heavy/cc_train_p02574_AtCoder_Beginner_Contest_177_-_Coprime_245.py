import sys
import math
from functools import reduce
N = str(input())
A = list(map(int, input().split()))

M = 10 ** 6
sieve = [0] * (M+1)
for a in  A:
    sieve[a] += 1

def gcd(*numbers):
    return reduce(math.gcd, numbers)

d = 0
for i in range(2, M+1):
    tmp = 0
    for j in range(i,M+1,i):
        tmp += sieve[j]
    if tmp > 1:
        d = 1
        break

            
if d == 0:
    print('pairwise coprime')
    exit()

if gcd(*A) == 1:
    print('setwise coprime')
    exit()

print('not coprime')
