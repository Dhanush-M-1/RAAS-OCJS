# Author: S Mahesh Raju
# Username: maheshraju2020
# Date: 21/07/2020

from sys import stdin,stdout
from math import gcd, ceil, sqrt
from collections import Counter
from bisect import bisect_left, bisect_right
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
mod = 1000000007

tc = ii1()
for _ in range(tc):
    n, m = iia()
    arr1 = iia()
    arr2 = iia()
    k = set(arr1) & set(arr2)
    if len(k):
        print('YES')
        print(1, k.pop())
    else:
        print('NO')    