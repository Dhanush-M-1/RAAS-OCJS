import sys
import math
import heapq
import collections
from collections import OrderedDict 
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

n, k = inputnums()
mins = [ [ [] for i in range(2) ] for j in range(2) ] 
for i in range(n):
    t, a, b = inputnums()
    mins[a][b].append(t)
mins[1][0].sort()
mins[0][1].sort()
x = len(mins[1][0])
y = len(mins[0][1])
for i in range(min(x, y)):
    mins[1][1].append(mins[1][0][i] + mins[0][1][i])
mins[1][1].sort()
ans = 0
if len(mins[1][1]) < k:
    ans = -1
if ans != -1:
    for i in range(k):
        ans += mins[1][1][i]
print (ans)