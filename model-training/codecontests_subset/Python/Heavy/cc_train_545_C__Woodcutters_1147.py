import sys
import string

from collections import Counter, defaultdict
from math import fsum, sqrt, gcd, ceil, factorial
from itertools import combinations,permutations

# input = sys.stdin.readline
flush = lambda : sys.stdout.flush
comb = lambda x , y : (factorial(x) // factorial(y)) // factorial(x - y) 


#inputs
# ip = lambda : input().rstrip()
ip = lambda : input()
ii = lambda : int(input())
r = lambda : map(int, input().split())
rr = lambda : list(r())


n = ii()
arr = [rr() for _ in range(n)]
ans = 2

for i in range(1,n-1):
    if arr[i][0] - arr[i][1] > arr[i-1][0]:
        ans += 1
    else:
        # if arr[i+1][0] - arr[i+1][1] <= arr[i][0] or i == n-2:
        if arr[i][0] + arr[i][1] < arr[i+1][0]:
            ans += 1
            arr[i][0] += arr[i][1]
                
print(ans if n>1 else 1)