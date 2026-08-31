from collections import Counter
from bisect import bisect_right, bisect_left
from math import ceil

def solve(b,total,x,n):
    if len(b) == 0:
        return -1
    if (x > b[-1] and total<=0):
        return -1
    if x <= b[-1]:
        return bisect_left(b,x)
    c = ceil((x-b[-1])/total)
    idx = bisect_left(b,x-c*total)
    return c*n + idx
 
t = int(input())
for i in range(t):
    n,m = tuple(map(int,(input().split())))
    a = list(map(int,input().split()))
    x = list(map(int,input().split()))
    total = sum(a)
    b = [0]
    c = 0
    for e in a:
        c+=e
        b.append(max(c,b[-1]))
        
    b = b[1:]
    for xi in x:
        print(solve(b,total,xi,n),end=" ")
    print()