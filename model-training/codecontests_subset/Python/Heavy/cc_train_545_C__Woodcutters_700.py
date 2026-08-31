import math,sys,bisect,heapq
from collections import defaultdict,Counter,deque
from itertools import groupby,accumulate
#sys.setrecursionlimit(200000000)
int1 = lambda x: int(x) - 1
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
ilele = lambda: map(int,input().split())
alele = lambda: list(map(int, input().split()))
ilelec = lambda: map(int1,input().split())
alelec = lambda: list(map(int1, input().split()))
def list2d(a, b, c): return [[c] * b for i in range(a)]
def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
#MOD = 1000000000 + 7
def Y(c):  print(["NO","YES"][c])
def y(c):  print(["no","yes"][c])
def Yy(c):  print(["No","Yes"][c])
    
n = int(input())
ans=0
xprev = -1e9;hprev = 0;status = -1
for i in range(n):
    x,h= ilele()
    if status == 1:
        if xprev + hprev >= x:
            ans -= 1
            status = -1
    #print(ans,x,h,status)
    if status == -1:
        if x-h > xprev:
            status = -1
        else:
            status = 1
    elif status == 1:
        if x - h > xprev+hprev:
            status = -1
        else:
            status = 1
    ans+=1
    xprev = x
    hprev = h

print(ans)
            
            

