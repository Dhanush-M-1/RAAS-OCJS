# Author: S Mahesh Raju
# Username: maheshraju2020
# Date: 10/07/2020

from sys import stdin,stdout
from math import gcd, ceil, sqrt
from collections import Counter, deque
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
mod = 1000000007

tc = ii1()
for i in range(tc):
    n = ii1()
    arr = iia()
    arr1 = deque(arr[:])
    cur1 = cur2 = 0
    while len(arr1) and arr1[0] >= cur1:
        arr1.popleft()
        cur1 += 1
    
    while len(arr1) and arr1[-1] >= cur2:
        arr1.pop()
        cur2 += 1
    
    if cur1 != cur2 and not len(arr1):
        print("Yes")
    else:
        arr1 = deque(arr[:])
        cur1 = cur2 = 0
        while len(arr1) and arr1[-1] >= cur1:
            arr1.pop()
            cur1 += 1

        while len(arr1) and arr1[0] >= cur2:
            arr1.popleft()
            cur2 += 1
        
        if cur1 != cur2 and not len(arr1):
            print("Yes")
        else:
            print("No")