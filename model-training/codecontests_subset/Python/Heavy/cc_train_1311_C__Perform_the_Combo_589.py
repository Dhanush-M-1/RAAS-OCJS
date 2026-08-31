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
    n, m = inputnums()
    s = inputstringnum()
    p = inputlist()
    alphabet=[0]*26
    twod=[[0 for j in range(26)] for i in range(n)]
    twod[0][s[0]] += 1
    for i in range(1, n):
        for j in range(26):
            twod[i][j]=twod[i-1][j]
        twod[i][s[i]] += 1
    for i in p:
        for j in range(26):
            alphabet[j] += twod[i - 1][j]
    for i in s:
        alphabet[i] += 1
    print(*alphabet)