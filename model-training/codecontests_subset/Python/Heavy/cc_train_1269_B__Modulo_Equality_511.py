import sys
import math
import heapq
import collections
def inputnum():
    return(int(input()))
def inputnums():
    return(map(int,input().split()))
def inputlist():
    return(list(map(int,input().split())))
def inputstring():
    return([x for x in input()])
def inputstringnum():
    return([ord(x)-ord('a') for x in input()])
def inputmatrixchar(rows):
    arr2d = [[j for j in input().strip()] for i in range(rows)] 
    return arr2d
def inputmatrixint(rows):
    arr2d = []
    for _ in range(rows):
        arr2d.append([int(i) for i in input().split()])
    return arr2d
    
n, m = inputnums()
a = inputlist()
b = inputlist()
d = b 
d.sort()
ans = m 
c = [0]*n
for i in range(n):
    x = (b[i]-a[0])%m
    for j in range(n):
        c[j] = (a[j]+x)%m
    c.sort()
    if c == d:
        ans = min(ans, x)
print(ans)