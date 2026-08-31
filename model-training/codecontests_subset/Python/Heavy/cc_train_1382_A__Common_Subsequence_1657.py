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
def inputmatrixchar(rows):
    arr2d = [[j for j in input().strip()] for i in range(rows)] 
    return arr2d
def inputmatrixint(rows):
    arr2d = []
    for _ in range(rows):
        arr2d.append([int(i) for i in input().split()])
    return arr2d
    
t=int(input())
for q in range(t):
    n, m = inputnums()
    a = inputlist()
    b = inputlist()
    mp = [0]*1001
    for i in range(n):
        mp[a[i]] += 1 
    ans = 0
    for i in range(m):
        if mp[b[i]] >= 1:
            ans = b[i]
    if ans > 0:
        print("YES")
        print(1, ans)
    else:
        print("NO")