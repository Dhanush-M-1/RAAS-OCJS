# Author: S Mahesh Raju
# Username: maheshraju2020
# Date: 29/04/2020

from sys import stdin,stdout
from math import gcd, ceil, sqrt
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
mod = 1000000007

n = ii1()
res = n
for i in range(1, int(sqrt(n)) + 1):
    if n % i == 0:
        a = i
        b = n // i
        if a * b // gcd(a, b) == n:
            res = min(res, max(n % i, n // i))
print(res, n // res)
