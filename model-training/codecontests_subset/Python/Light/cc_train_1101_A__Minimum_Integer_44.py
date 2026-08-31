import math as mt
import sys, string
from collections import Counter, defaultdict
input = sys.stdin.readline

# input functions
I = lambda : int(input())
M = lambda : map(int, input().split())
ARR = lambda: list(map(int, input().split()))

def printARR(arr):
    for e in arr:
        print(e, end=" ")
    print()

def main():
    l, r, d = M()
    if d < l:
        print(d)
    else:
        ans = (r+(d-r%d))
        print(ans)



tc = 1
tc = I()
for _ in range(tc):
    main()