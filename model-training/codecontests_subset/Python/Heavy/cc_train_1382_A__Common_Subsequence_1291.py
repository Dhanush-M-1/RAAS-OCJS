import math as mt
import sys, string
from collections import Counter, defaultdict
input = sys.stdin.readline

MOD = 1000000007

# input functions
I = lambda : int(input())
M = lambda : map(int, input().split())
Ms = lambda : map(str, input().split()) 
ARR = lambda: list(map(int, input().split()))

def main():
    n, m = M()
    a = ARR()
    b = ARR()
    possible = False
    ans = 0
    for i in range(n):
        for j in range(m):
            if a[i] == b[j]:
                possible = True
                ans = a[i]
                break
        if possible:
            break
    
    if possible:
        print("YES")
        print(1, ans)
    else:
        print("NO")

# testcases
tc = I()
for _ in range(tc):
    main()