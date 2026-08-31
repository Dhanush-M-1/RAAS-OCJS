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
    n = inputnum()
    two = 0
    three = 0
    while n%2 == 0 or n%3 == 0:
        if n%2 == 0: 
            n//=2
            two += 1 
        if n%3 == 0:
            n//=3 
            three += 1 
    if n > 1 or two > three:
        print(-1)
    else:
        print (2*three - two)