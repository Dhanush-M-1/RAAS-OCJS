import math,sys,bisect,heapq
from collections import defaultdict,Counter,deque
from itertools import groupby,accumulate
#sys.setrecursionlimit(1000000)
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
ilele = lambda: map(int,input().split())
alele = lambda: list(map(int, input().split()))
#def list2d(a, b, c): return [[c] * b for i in range(a)]
#def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
#MOD = 1000000000 + 7
def Y(c):  print(["NO","YES"][c])
def y(c):  print(["no","yes"][c])
def Yy(c):  print(["No","Yes"][c])

n,k = ilele()
a = [];b = [];d = []
for i in range(n):
    t,x,y = ilele()
    if x == y == 1: d.append(t)
    elif x==1:  a.append(t)
    elif y == 1:    b.append(t)
a.sort();b.sort()
for i,j in zip(a,b):    d.append(i+j)
print(-1) if len(d)<k else print(sum(sorted(d)[:k]))