import math
import sys
from collections import defaultdict,Counter,deque,OrderedDict
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

for _ in range(int(input())):
    N = int(input())
    A = alele()
    if N<6:
        print(0,0,0)
    else:
        B = [list(g) for k,g in groupby(A)]
        #print(B)
        g,s,b =0,0,0
        for i in B:
            if g==0:
                g = len(i)
            elif s==0 or s<=g:
                s += len(i)
            elif b<=g:
                b+= len(i)
            elif b+s+g+len(i) <= N//2:
                b+=len(i)
            else:
                break
        if g+s+b > N//2 or g>=s or g>=b:
            print(0,0,0)
        else:
            print(g,s,b)
                
                
                
