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
    ind1 = 0
    ind2 = n-1
    for i in range(n):
        if a[i] < i:
            break
        ind1 = i;
    for i in reversed(range(n)):
        if a[i] < n-1-i:
            break
        ind2 = i;
    if ind1 < ind2:
        print("No")
    else:
        print("Yes")