import sys
from operator import itemgetter
input=sys.stdin.readline
#t=int(input())
from collections import defaultdict as dc
from bisect import bisect_left, bisect_right
import math
for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    a=-1
    b=n
    for i in range(n):
        if l[i]<i:
            break
        a=i
    for i in range(n-1,-1,-1):
        if l[i]<n-1-i:
            break
        b=i
    if b<=a:
        print("Yes")
    else:
        print("NO")