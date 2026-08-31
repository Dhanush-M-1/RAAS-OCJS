# Author: S Mahesh Raju
# Username: maheshraju2020
# Date: 10/07/2020

from sys import stdin,stdout
from math import gcd, ceil, sqrt
from collections import Counter
from bisect import bisect_left, bisect_right
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
mod = 1000000007

def primeFactors(n):
    d = {}
    while n % 2 == 0:
        d.setdefault(2, [0])[0] += 1
        n = n // 2
    while n % 3 == 0:
        d.setdefault(3, [0])[0] += 1
        n = n // 3
    d.setdefault(n, [1])
    return d

tc = ii1()
for _ in range(tc):
    n = ii1()
    if n == 1:
        print(0)
    else:
        fact = primeFactors(n)
        for i in fact:
            if i == 2 or i == 3 or i == 1:
                continue
            else:
                print(-1)
                break
        else:
            res = 0
            two = fact.get(2, [0])[0]
            three = fact.get(3, [0])[0]
            op = min(two, three)
            two -= op
            three -= op
            if two > three:
                print(-1)
            else:
                res += op
                res += three * 2
                print(res)
