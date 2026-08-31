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
    
t = int(input())
for q in range(t):
    n = inputnum()
    a = inputlist()
    mx = -10000000000
    mn = 10000000000
    for i in range(n):
        if a[i] == -1:
            if i > 0 and a[i-1] != -1:
                mn = min(a[i-1], mn)
                mx = max(a[i-1], mx)
            if i < n-1 and a[i+1] != -1:
                mn = min(a[i+1], mn)
                mx = max(a[i+1], mx)
    k = (mx+mn)//2
    ans = 0
    for i in range(n):
        if a[i] == -1:
            a[i] = k 
        if i:
            ans = max(ans, abs(a[i]-a[i-1]))
    print(ans, k)