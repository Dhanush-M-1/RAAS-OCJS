import sys
import math
import heapq
import collections
fast_reader = sys.stdin.readline
fast_writer = sys.stdout.write
def input():
	return fast_reader().strip()
def print(*argv):
	fast_writer(' '.join((str(i)) for i in argv))
	fast_writer('\n')
def printspace(*argv):
	fast_writer(' '.join((str(i)) for i in argv))
	fast_writer(' ')
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
    
mod = 1000000007
def fact(n): 
    res = 1
    for i in range(2, n+1): 
        res = (res * i)%mod
    return res 

n = inputnum()
print(((fact(n) - pow(2, n-1, mod))+mod)%mod)