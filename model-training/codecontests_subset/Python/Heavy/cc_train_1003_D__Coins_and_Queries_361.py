# Author: S Mahesh Raju
# Username: maheshraju2020
# Date: 07/07/2020

from sys import stdin,stdout
from math import gcd, ceil, sqrt
from collections import Counter
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
mod = 1000000007

n, q = iia()
d = Counter(iia())
for i in range(q):
    cur = ii1()
    count = 0
    for i in sorted(d, reverse=True):
        if cur >= i:
            temp = min(cur // i, d[i])
            cur -= temp * i
            count += temp
        
        if cur == 0:
            break
    if cur:
        print(-1)
    else:
        print(count)
        
        
        