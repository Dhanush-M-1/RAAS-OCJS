import sys
import math
import heapq
from collections import defaultdict, deque
input = sys.stdin.readline
def r():
    return int(input())
def rm():
    return map(int,input().split())
def rl():
    return list(map(int,input().split()))

n,k=rm()
a=[];b=[];both=[]
for _ in range(n):
    t,ai,bi=rm()
    if ai==1 and bi==1:
        both.append(t)
    elif ai==1:
        a.append(t)
    elif bi==1:
        b.append(t)
a.sort()
b.sort()
if len(a)<k-len(both) or len(b)<k-len(both):
    print(-1)
else:
    c=[]
    cl=min(len(a),len(b))
    for i in range(cl):
        c.append(a[i]+b[i])
    both+=c
    both.sort()
    print(sum(both[:k]))