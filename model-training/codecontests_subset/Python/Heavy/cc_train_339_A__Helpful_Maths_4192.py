from collections import Counter
import math
import sys
from bisect import bisect,bisect_left,bisect_right
def input(): return sys.stdin.readline().strip()
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(N=None): return list(MAP()) if N is None else [INT() for i in range(N)]
def mod(): return 10**9+7
 
#for _ in range(INT()):
#n = INT()
s = input()
#n,k = MAP()
#arr = LIST()
arr = []
for i in range(0,len(s),2):
    arr.append(int(s[i]))
arr.sort()
ans = ""
for i in range(len(arr)):
    ans += str(arr[i])
    if i != len(arr)-1:
        ans += "+"
print(ans)
