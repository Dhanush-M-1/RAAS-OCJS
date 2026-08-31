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

def computeGCD(x, y): 
    while(y): 
        x, y = y, x % y 
    return x 
    
x = inputnum()
i = 1
a = 0
while i*i <= x:
    if x%i == 0 and computeGCD(x//i, i) == 1:
        a = i
    i += 1
print(a, x//a)