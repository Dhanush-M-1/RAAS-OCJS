import math
import sys
from collections import defaultdict,Counter,deque
import bisect
#sys.setrecursionlimit(1000000)
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
ilele = lambda: map(int,input().split())
alele = lambda: list(map(int, input().split()))
def list2d(a, b, c): return [[c] * b for i in range(a)]
#def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
#INF = 10 ** 18
#MOD = 1000000000 + 7
from itertools import accumulate,groupby
dp = []

N1,N2 = ilele()
if N1==N2:
    print(0)
else:
    a,b,c,d,e,f =0,0,0,0,0,0
    while N1>0 and N1%2 ==0:
        a+=1
        N1//=2
    while N1>0 and N1%3 ==0:
        b+=1
        N1//=3
    while N1>0 and N1%5 ==0:
        c+=1
        N1//=5
    while N2>0 and N2%2 ==0:
        d+=1
        N2//=2
    while N2>0 and N2%3 ==0:
        e+=1
        N2//=3
    while N2>0 and N2%5 ==0:
        f+=1
        N2//=5
    if N1 != N2:
        print(-1)
    else:
        print(abs(a-d) + abs(b-e) + abs(c-f))