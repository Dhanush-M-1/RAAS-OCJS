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

for _ in range(int(input())):
    N = int(input())
    a = 0
    b = 0
    while N % 3 == 0:
        a+=1
        N //=3
    while N % 2 == 0:
        b+=1
        N //=2
    if N != 1 or b > a:
        print(-1)
    else:
        print(2*a - b)
    